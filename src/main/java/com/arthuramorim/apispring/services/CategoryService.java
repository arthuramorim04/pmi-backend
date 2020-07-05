package com.arthuramorim.apispring.services;

import com.arthuramorim.apispring.entity.Category;
import com.arthuramorim.apispring.repositorys.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
// todos as chamadas utilizando o UserRepository devem ser feitas a partir dessa classe

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

}
