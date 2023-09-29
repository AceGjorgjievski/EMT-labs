package mk.ukim.finki.emt.labs.library.service;

import mk.ukim.finki.emt.labs.library.model.User;
import mk.ukim.finki.emt.labs.library.model.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    User login(String username, String password);

    User register(String name, String surname, String email,
                  String username, String password, String passwordRepeat, Role role);

    User create(String name, String surname, String email,
                String username, String password, Role role);

    Optional<User> create(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);

    User edit(Long id, String name, String surname, String email,
              String username, Role role);
    Optional<User> edit(Long id, User user);
}
