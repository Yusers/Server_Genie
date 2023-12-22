package com.website.genie.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column
    private String material;

    @Column
    private String fit;

    @Column
    private double price;

    @Column
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private CartEntity cart;

    @OneToMany(mappedBy = "product")
    private List<OrderItemsEntity> order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
