package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal totalPrice;
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<CartDetail> cartDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
