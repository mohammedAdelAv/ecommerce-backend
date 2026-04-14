package ecommerce.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login
  @PostMapping("/login")
public String login(@RequestBody User user) {
    return userService.login(user.getUsername(), user.getPassword());
}
}