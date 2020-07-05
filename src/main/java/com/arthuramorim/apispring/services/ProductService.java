package com.arthuramorim.apispring.services;

import com.arthuramorim.apispring.entity.Product;
import com.arthuramorim.apispring.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
// todos as chamadas utilizando o UserRepository devem ser feitas a partir dessa classe

    @Autowired
    private ProductRepository categoryRepository;

    public List<Product> findAll(){
        return categoryRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = categoryRepository.findById(id);
        return obj.get();
    }

}
