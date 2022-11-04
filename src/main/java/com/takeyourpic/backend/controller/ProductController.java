package com.takeyourpic.backend.controller;

import com.takeyourpic.backend.model.Product;
import com.takeyourpic.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }

    @PutMapping(path = "/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable Long id){
        productService.updateProduct(id, product);

        return "Successfully updated";
    }

    @PostMapping
    public String createProduct(@RequestBody Product product){
        productService.createProduct(product);

        return "Successfully created";
    }

    @DeleteMapping(path = "{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);

        return "Successfully deleted";
    }
}
