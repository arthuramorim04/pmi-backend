package com.arthuramorim.apispring.services;

import com.arthuramorim.apispring.entity.Order;
import com.arthuramorim.apispring.repositorys.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
// todos as chamadas utilizando o UserRepository devem ser feitas a partir dessa classe

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }

}
