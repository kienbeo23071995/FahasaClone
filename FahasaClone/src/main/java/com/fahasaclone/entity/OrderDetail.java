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
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private BigDecimal price;

    private double discount;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String feedback;

    @ManyToMany()
    @JoinTable(name = "OrderStatusDetail",joinColumns = @JoinColumn(name = "orderStatus_id"),
    inverseJoinColumns = @JoinColumn(name = "orderDetail_id"))
    private Set<OrderStatus> orderStatuses;
}
