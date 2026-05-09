package ecommerce.user;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register
    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        user.setRole("USER");
        return userService.register(user);
    }

    // Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        return userService.login(user.getEmail(), user.getPassword());
    }
}