package org.example.ordersservice.Services;


import org.example.ordersservice.dto.OrderDetailsDto;
import org.example.ordersservice.dto.OrderDto;
import org.example.ordersservice.dto.ProductDto;
import org.example.ordersservice.dto.UserDto;
import org.example.ordersservice.entities.Order;
import org.example.ordersservice.repository.OrderRepository;
import org.example.ordersservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Value("${USER_SERVICE_URL:http://myapp.local/users}")
    private String userServiceUrl;


    public OrderDetailsDto createOrder(OrderDto orderDto) {

        if(productRepository.findById(orderDto.getProduct_id()).isPresent()) {
            if(getUserById(orderDto.getUser_id()) != null){
                Order order = mapper.map(orderDto, Order.class);
                order = orderRepository.save(order);

                OrderDetailsDto orderDetailsDto = mapper.map(order, OrderDetailsDto.class);
                orderDetailsDto.setProduct(mapper.map(productRepository.findById(orderDto.getProduct_id()).get(), ProductDto.class));
                orderDetailsDto.setUser(getUserById(orderDto.getUser_id()));
                return orderDetailsDto;
            }
        }


        return null;
    }

    public OrderDetailsDto getOrderById(Long id) {
        OrderDto order = orderRepository
                .findById(id).map(o -> mapper.map(o, OrderDto.class))
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                .id(id)
                .createdAt(order.getCreatedAt())
                .quantity(order.getQuantity())
                .build();

        if(productRepository.findById(order.getProduct_id()).isPresent()) {
            orderDetailsDto.setProduct(mapper.map(productRepository.findById(order.getProduct_id()).get(), ProductDto.class));
        }

        orderDetailsDto.setUser(getUserById(order.getUser_id()));
        orderDetailsDto.getUser().setId(order.getUser_id());

        return orderDetailsDto;
    }

    public List<OrderDetailsDto> getOrdersByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUser_id(userId);

        return orders
                .stream()
                .map(order -> {
                    OrderDetailsDto orderDetailsDto = mapper.map(order, OrderDetailsDto.class);
                    orderDetailsDto.setId(order.getId());
                    orderDetailsDto.setProduct(mapper.map(productRepository.findById(order.getProduct_id()).get(), ProductDto.class));
                    orderDetailsDto.setUser(getUserById(order.getUser_id()));
                    return orderDetailsDto;
                })
                .toList();
    }

    public UserDto getUserById(Long id) {

        String url = userServiceUrl + "/api/users/" +  + id;

        UserDto user = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UserDto.class)
                .block();

        if(user == null) {
            return null;
        }
        user.setId(id);

        return user;
    }
}
