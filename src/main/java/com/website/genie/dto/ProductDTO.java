package com.website.genie.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class ProductDTO extends BaseDTO {
    private String title;

    private String category;

    private String material;

    private String fit;

    private double price;

    private String imageUrl;

    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long id, Date createDate, String modifiedBy, Date modifiedDate, String title, String category, String material, String fit, double price, String imageUrl, String description) {
        super(id, createDate, modifiedBy, modifiedDate);
        this.title = title;
        this.category = category;
        this.material = material;
        this.fit = fit;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", material='" + material + '\'' +
                ", fit='" + fit + '\'' +
                ", price='" + price + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
