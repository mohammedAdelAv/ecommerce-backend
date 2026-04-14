package ecommerce.order;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ecommerce.payment.Payment;
import ecommerce.product.Product;
import ecommerce.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders") // مهم علشان order كلمة محجوزة
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;
    private String status; // pending / completed

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "order")
    @JsonIgnore 
    private Payment payment;

        @ManyToMany
    @JoinTable(
        name = "order_products",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @JsonIgnore
    private List<Product> products;
}