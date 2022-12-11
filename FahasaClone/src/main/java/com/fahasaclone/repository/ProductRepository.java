package com.fahasaclone.repository;

import com.fahasaclone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findByTitleLikeIgnoreCaseOrAuthorLikeIgnoreCase(String title, String author);

}