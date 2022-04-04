package com.aavidsoft.productsassignment;

import java.io.Serializable;

//Model class
public class Product implements Serializable {
    private int id;
    private String title;
    private int price;
    private String description;
    private int imageId;

    public Product(int id, String title, int price, String description, int imageId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
