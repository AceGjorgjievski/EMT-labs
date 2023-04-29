package mk.ukim.finki.emt.labs.library.model;

import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt.labs.library.model.enums.Role;


@Entity
@Data
@Table(name="librarian_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    //todo list od carts.. ?

    public User() {
    }

    public User(String name, String surname, String email, String username, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
