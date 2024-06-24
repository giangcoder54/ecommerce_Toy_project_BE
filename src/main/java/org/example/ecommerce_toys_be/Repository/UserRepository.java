package org.example.ecommerce_toys_be.Repository;

import org.example.ecommerce_toys_be.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    // dung Optional de tranh loi NullPointerException
    Optional<User> findByUsername(String username);
}
