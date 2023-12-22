package com.website.genie.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "payment")
public class PaymentEntity extends BaseEntity {
    private String paymentMethod;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "payment")
    private List<OrderEntity> orders;
}
