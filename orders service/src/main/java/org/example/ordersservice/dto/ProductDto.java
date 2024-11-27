package org.example.ordersservice.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String productName;

    private String unitPrice;
    
}
