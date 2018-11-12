package com.testCoffee.testCoffee.repository;

import com.testCoffee.testCoffee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
