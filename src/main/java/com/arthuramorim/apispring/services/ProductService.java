package com.arthuramorim.apispring.services;

import com.arthuramorim.apispring.entity.Product;
import com.arthuramorim.apispring.repositorys.CategoryRepository;
import com.arthuramorim.apispring.repositorys.ProductRepository;
import com.arthuramorim.apispring.services.exceptions.DatabaseException;
import com.arthuramorim.apispring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
// todos as chamadas utilizando o UserRepository devem ser feitas a partir dessa classe

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //busca por categoria
    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

    public Product insert(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id){
        try{
            productRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Product updateQuantity(Product product){

        return null;
    }

}
