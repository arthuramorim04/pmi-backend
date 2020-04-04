package br.com.plugshop.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.plugshop.api.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
