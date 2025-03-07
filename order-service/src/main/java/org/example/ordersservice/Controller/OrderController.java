package org.example.ordersservice.Controller;

import org.example.ordersservice.Services.OrderService;
import org.example.ordersservice.dto.OrderDetailsDto;
import org.example.ordersservice.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @CrossOrigin(origins = "*")
    @PostMapping
    public OrderDetailsDto createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public OrderDetailsDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/user/{userId}")
    public List<OrderDetailsDto> getAllOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

}
