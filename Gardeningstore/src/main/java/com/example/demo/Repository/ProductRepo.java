package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long> {
    // Add any custom query methods if needed
}