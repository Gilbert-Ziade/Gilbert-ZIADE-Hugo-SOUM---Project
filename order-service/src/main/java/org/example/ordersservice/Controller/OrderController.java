package org.example.ordersservice.Controller;

import org.example.ordersservice.Services.OrderService;
import org.example.ordersservice.dto.OrderDetailsDto;
import org.example.ordersservice.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public OrderDetailsDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDetailsDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

}
