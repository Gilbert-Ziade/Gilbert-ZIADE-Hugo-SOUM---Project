package org.example.ordersservice.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, unique = true, name = "unit_price")
    private String unitPrice;
}
