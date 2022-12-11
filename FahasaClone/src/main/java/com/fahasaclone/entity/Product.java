package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String title;
    private BigDecimal price;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String isbn;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String author;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String description;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    private int publish_year;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private double discount;
    @ManyToOne
    @JoinColumn(name = "book_layout_id")
    private BookLayout bookLayout;
    private boolean active;
    private int rate_sum;
    private int rate_count;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;
    @OneToMany(mappedBy = "product")
    private Set<CartDetail> cartDetails;
    @OneToMany(mappedBy = "product")
    private Set<OrderDetail> orderDetails;
}
