package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


// ja esta registrada como repositorio por extender a JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
