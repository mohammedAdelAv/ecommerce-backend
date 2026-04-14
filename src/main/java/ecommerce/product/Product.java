package ecommerce.product;

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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private Integer stock;
    private String description;

     @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Order> orders;
}