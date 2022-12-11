package com.fahasaclone.repository;

import com.fahasaclone.entity.BookLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLayoutRepository extends JpaRepository<BookLayout, Long> {
}