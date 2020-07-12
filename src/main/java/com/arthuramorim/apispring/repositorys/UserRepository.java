package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// ja esta registrada como repositorio por extender a JpaRepository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    User findByName(String name);

}
