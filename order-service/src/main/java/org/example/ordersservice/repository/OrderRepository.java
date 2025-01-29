package org.example.ordersservice.repository;

import org.example.ordersservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.user_id = :userId")
    List<Order> findByUser_id(Long userId);

}
