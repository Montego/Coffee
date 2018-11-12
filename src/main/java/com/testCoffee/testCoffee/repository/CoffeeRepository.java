package com.testCoffee.testCoffee.repository;

import com.testCoffee.testCoffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {
    List<Coffee> findByName(String name);
}
