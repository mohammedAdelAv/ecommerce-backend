package ecommerce.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Dependency Injection : inject the repository to interact with the database :
    // inject repository into service
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Register
    public User register(User user) {
        return userRepo.save(user);
    }

    // Login
    public User login(String username, String password) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password");
        }

        return user;
    }

}
