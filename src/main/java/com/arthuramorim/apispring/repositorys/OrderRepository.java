package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// ja esta registrada como repositorio por extender a JpaRepository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
