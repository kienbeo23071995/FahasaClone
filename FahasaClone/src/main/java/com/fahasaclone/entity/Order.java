package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal totalPrice;

    private Date order_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String address;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String phone;

    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String receive_name;

    @ManyToOne
    @JoinColumn(name = "shipper_id", nullable = false)
    private User shipper;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
}
