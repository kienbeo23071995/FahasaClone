package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinFormula;
import org.hibernate.annotations.Nationalized;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parrent_category_id",referencedColumnName = "id")
    private Category parrentCategory;

    @OneToMany(mappedBy = "id")
    private Set<Category> childCategories;
}
