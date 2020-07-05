package com.arthuramorim.apispring.repositorys;

import com.arthuramorim.apispring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
