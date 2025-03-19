package com.maxime.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    @NotEmpty(message = "Please enter a name!")
    @Size(min = 2, max = 50, message = "Name length must be between 2 and 50")
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price cannot be null!")
    @DecimalMin(value = "0.0", inclusive = false, message = "Please enter a positive price!")
    private Double price;


    public Product() {
    }

    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}