package com.fahasaclone.repository;

import com.fahasaclone.entity.Category;
import com.fahasaclone.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByParrentCategory_Id(Long id);

    @Procedure("selectProducts")
    Set<Product> getProductsByCategoryId(Long id);
}