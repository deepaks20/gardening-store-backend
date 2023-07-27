package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Products;
import com.example.demo.Repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo repo1;

    @Autowired
    public ProductService(ProductRepo repo1) {
        this.repo1 = repo1;
    }

    public List<Products> getAllProducts() {
        return repo1.findAll();
    }

    public Optional<Products> getProductById(Long id) {
        return repo1.findById(id);
    }

    public Products createProduct(Products product) {
        return repo1.save(product);
    }

    public Products updateProduct(Long id, Products productDetails) {
        Products product = getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        product.setProductName(productDetails.getProductName());
        product.setOriginalPrice(productDetails.getOriginalPrice());
        product.setDiscountedPrice(productDetails.getDiscountedPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setShipping(productDetails.getShipping());

        return repo1.save(product);
    }

    public void deleteProduct(Long id) {
        repo1.deleteById(id);
    }
}