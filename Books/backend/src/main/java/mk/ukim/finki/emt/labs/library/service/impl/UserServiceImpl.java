package mk.ukim.finki.emt.labs.library.service.impl;

import mk.ukim.finki.emt.labs.library.model.User;
import mk.ukim.finki.emt.labs.library.model.enums.Role;
import mk.ukim.finki.emt.labs.library.model.exceptions.*;
import mk.ukim.finki.emt.labs.library.repository.UserRepository;
import mk.ukim.finki.emt.labs.library.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User login(String username, String password) {
        if(username == null || password == null)
            throw new InvalidArgumentException(username, password);

        return this.userRepository
                .findUserByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String name, String surname, String email, String username,
                         String password, String passwordRepeat, Role role) {
        if (name == null || name.isEmpty() || surname == null || surname.isEmpty())
            throw new InvalidUserCredentialsException();

        if (!password.equals(passwordRepeat))
            throw new PasswordNotMatchingException();

        if(this.userRepository.findUserByUsername(username).isPresent())
            throw new UserAlreadyExistsException(username);

        String encryptedPassword = this.passwordEncoder.encode(password);

        User user = new User(
                name,surname,
                username, email,
                encryptedPassword,
                role
        );

        return this.userRepository.save(user);
    }

    @Override
    public User create(String name, String surname, String email, String username, String password, Role role) {
        String encryptedPassword = this.passwordEncoder.encode(password);
        User user = new User(name, surname, email, username, encryptedPassword, role);
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> create(User user) {
        User user1 = new User(
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
        return Optional.of(this.userRepository.save(user1));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);

    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User edit(Long id, String name, String surname, String email, String username, Role role) {
        User u = this.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        u.setName(name);
        u.setSurname(surname);

        u.setEmail(email);
        u.setUsername(username);

        u.setRole(role);

        return this.userRepository.save(u);
    }

    @Override
    public Optional<User> edit(Long id, User user) {
        User user1 = this.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user1.setName(user1.getName());
        user1.setSurname(user1.getSurname());
        user1.setUsername(user1.getUsername());
        user1.setEmail(user1.getEmail());
        user1.setPassword(user1.getPassword());
        user1.setRole(user1.getRole());

        return Optional.of(this.userRepository.save(user1));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = this.userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                u.getUsername(),
                u.getPassword(),
                Stream.of(new SimpleGrantedAuthority(u.getRole().toString())).collect(Collectors.toList())
        );

        return userDetails;
    }
}
