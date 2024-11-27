package org.example.ordersservice.Services;


import org.example.ordersservice.dto.OrderDetailsDto;
import org.example.ordersservice.dto.OrderDto;
import org.example.ordersservice.dto.ProductDto;
import org.example.ordersservice.entities.Order;
import org.example.ordersservice.repository.OrderRepository;
import org.example.ordersservice.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    @Autowired
    private ModelMapper mapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    public OrderDetailsDto createOrder(OrderDto orderDto) {

        if(productRepository.findById(orderDto.getProduct_id()).isPresent()) {
            return null;
            /*Order order = mapper.map(orderDto, Order.class);
            orderRepository.save(order);*/
        }


        return null;
    }

    public OrderDetailsDto getOrderById(Long id) {
        OrderDto order = orderRepository
                .findById(id).map(o -> mapper.map(o, OrderDto.class))
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderDetailsDto orderDetailsDto = mapper.map(order, OrderDetailsDto.class);

        if(productRepository.findById(order.getProduct_id()).isPresent()) {
            orderDetailsDto.setProduct(mapper.map(productRepository.findById(order.getProduct_id()).get(), ProductDto.class));
        }

        return orderDetailsDto;
    }
}
