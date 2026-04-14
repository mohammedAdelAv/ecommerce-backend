package ecommerce.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ecommerce.order.Order;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

        private String role;

     @OneToMany(mappedBy = "user")
     @JsonIgnore
    private List<Order> orders;

}
