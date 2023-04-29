package mk.ukim.finki.emt.labs.library.web.rest;


import mk.ukim.finki.emt.labs.library.model.Country;
import mk.ukim.finki.emt.labs.library.model.User;
import mk.ukim.finki.emt.labs.library.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return this.userService.findById(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user) {
        return this.userService.create(user)
                .map(user1 -> ResponseEntity.ok().body(user1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<User> edit(@PathVariable Long id, @RequestBody User user) {
        return this.userService.edit(id, user)
                .map(user1 -> ResponseEntity.ok().body(user1))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        this.userService.deleteById(id);
        if (this.userService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
