package com.takeyourpic.backend.service;

import com.takeyourpic.backend.model.Product;
import com.takeyourpic.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);

        return product;
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Long id, Product product){
        Product foundProduct = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product does not exist"));

        if (foundProduct != null){
            foundProduct.setPrice(product.getPrice());
            foundProduct.setName(product.getName());
            foundProduct.setQuantity(product.getQuantity());
            productRepository.flush();
        }
    }

    public void deleteProduct(Long id){
        Product foundProduct = productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product does not exist"));

        if (foundProduct != null){
            productRepository.deleteById(id);
        }
    }
}
