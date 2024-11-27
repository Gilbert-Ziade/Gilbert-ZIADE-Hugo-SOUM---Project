package org.example.ordersservice.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    private String address;
    
}
