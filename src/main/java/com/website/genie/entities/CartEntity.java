package com.website.genie.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(columnDefinition = "int default 1")
    private int quantity;

    @OneToMany(mappedBy = "cart")
    private List<ProductEntity> products;
}
