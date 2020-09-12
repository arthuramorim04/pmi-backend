package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// ja esta registrada como repositorio por extender a JpaRepository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);

}
