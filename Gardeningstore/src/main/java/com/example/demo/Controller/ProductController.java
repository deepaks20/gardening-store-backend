package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Products;
import com.example.demo.Service.ProductService;


import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/products")
public class ProductController {
    private final ProductService apiService1;
   
    @Autowired
    public ProductController(ProductService apiService1) {
        this.apiService1 = apiService1;
      
    }

    @PostMapping("/addDetails")
    public ResponseEntity<Products> addProduct(@RequestBody Products product) {
        Products addedProduct = apiService1.createProduct(product);

        // Return the added product in the response
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = apiService1.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products product = apiService1.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products updatedProduct) {
        Products updatedItem = apiService1.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        apiService1.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}