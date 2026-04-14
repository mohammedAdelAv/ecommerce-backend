package ecommerce.user;

import org.springframework.stereotype.Service;

import ecommerce.security.JwtUtil;

@Service
public class UserService {

    // Dependency Injection : inject the repository to interact with the database :
    // inject repository into service
    private final UserRepo userRepo;
    private final JwtUtil jwtUtil;

    public UserService(UserRepo userRepo, JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
    }

    // Register
    public User register(User user) {
        return userRepo.save(user);
    }

    // Login
    public String login(String username, String password) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }

        return jwtUtil.generateToken(user.getUsername(), user.getRole());
    }

}
