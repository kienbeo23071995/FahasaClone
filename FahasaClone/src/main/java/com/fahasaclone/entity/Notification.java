package com.fahasaclone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String description;
    @Nationalized
    @Column(length = Integer.MAX_VALUE)
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}
