package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// ja esta registrada como repositorio por extender a JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
