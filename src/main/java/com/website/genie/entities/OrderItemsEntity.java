package com.website.genie.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders_item")
public class OrderItemsEntity extends BaseEntity {
    @Column
    private double price;
    @Column(columnDefinition = "int default 1")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "orders_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;


}
