package ecommerce.order;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import ecommerce.product.Product;
import ecommerce.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;
    private String status; // pending / completed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
   @ManyToMany
    @JsonIgnore
    private List<Product> products;
}