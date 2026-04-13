package ecommerce.payment;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method;   // cash / visa
    private String status;   // paid / pending

    private Long orderId; // مؤقتًا (هنربطه بعدين)
}