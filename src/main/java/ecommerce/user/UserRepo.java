package ecommerce.user;

// 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
// create a repository interface that extends JpaRepository, specifying the entity type and the type of its primary key
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}






