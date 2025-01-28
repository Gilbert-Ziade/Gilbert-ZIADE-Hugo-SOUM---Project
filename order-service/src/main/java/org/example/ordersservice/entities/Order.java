package org.example.ordersservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(nullable = false, name = "created_at")
    private String createdAt;

    @Column(nullable = false, name = "quantity")
    private int quantity;

    @JoinColumn(name = "product_id", nullable = false)
    private Long product_id;

    @JoinColumn(name = "user_id", nullable = false)
    private Long user_id;
}
