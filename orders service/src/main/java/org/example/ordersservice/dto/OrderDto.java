package org.example.ordersservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String createdAt;

    private int quantity;

    private Long product_id;

    private Long user_id;
}
