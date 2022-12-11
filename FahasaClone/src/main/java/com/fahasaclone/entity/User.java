package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nationalized
    @Column(unique = true, nullable = false,length = Integer.MAX_VALUE)
    private String email;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String firstName;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String lastName;
    @Nationalized
    @Column(nullable = false,length = Integer.MAX_VALUE)
    private String password;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String phone;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String address;
    private Date dob;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String imagePath;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String otp;
    private boolean active;
    private boolean gender;
    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Notification> notificationSet;
    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;
    @OneToMany(mappedBy = "user")
    private Set<Cart> carts;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    @OneToMany(mappedBy = "shipper")
    private Set<Order> shipperOrders;
}
