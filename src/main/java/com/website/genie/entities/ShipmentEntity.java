package com.website.genie.entities;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
@Table(name = "shipment")
public class ShipmentEntity extends BaseEntity{
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipcode;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "shipment")
    private List<OrderEntity> orders;

}
