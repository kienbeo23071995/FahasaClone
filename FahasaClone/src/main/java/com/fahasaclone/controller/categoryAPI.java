package com.fahasaclone.controller;

import com.fahasaclone.entity.Category;
import com.fahasaclone.exception.CategoryNotFoundException;
import com.fahasaclone.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/category")
@CrossOrigin
public class categoryAPI {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Set<Category>> getChildCategories(@PathVariable(name = "id") Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() ->
            new CategoryNotFoundException("Can't find category with id = " + id)
        );
        System.out.println(category.getChildCategories());
        Set<Category> categories = categoryRepository.findByParrentCategory_Id(id);
        return ResponseEntity.ok().body(categories);
    }



}
