package com.fahasaclone.controller;

import com.fahasaclone.entity.Product;
import com.fahasaclone.exception.ProductNotFoundException;
import com.fahasaclone.repository.CategoryRepository;
import com.fahasaclone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product")
public class productAPI {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<List<Product>> getALlProduct() {
        List<Product> list = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't find product with id = " + id));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Set<Product>> getProductByCategory(@PathVariable(name = "id") Long id) {
        Set<Product> products = categoryRepository.getProductsByCategoryId(id);
        if(products == null){
            throw new ProductNotFoundException("Can't find product with id = " + id);
        }
        else {
            return ResponseEntity.ok(products);
        }
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<?> searchByWord(@PathVariable(name = "keyword") String keyword){
        Set<Product> products = productRepository.findByTitleLikeIgnoreCaseOrAuthorLikeIgnoreCase(keyword,keyword);
        if(products.isEmpty()){
            return ResponseEntity.ok().body("No data");
        }
        else {
            return ResponseEntity.ok().body(products);
        }
    }
}
