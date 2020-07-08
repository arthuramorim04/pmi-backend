package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// ja esta registrada como repositorio por extender a JpaRepository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
