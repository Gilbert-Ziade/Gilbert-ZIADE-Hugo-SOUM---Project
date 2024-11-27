package org.example.ordersservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {

    private Long id;

    private String createdAt;

    private int quantity;

    private ProductDto product;

    private UserDto user;
}
