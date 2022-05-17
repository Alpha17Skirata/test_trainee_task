package com.raif.testtaskf.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "warehouse")
public class Socks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cotton_part")
    @Min(value = 0)
    @Max(value = 100)
    private int cottonPart;
    @Column(name = "color")
    private String color;
    @Column(name = "quantity")
    @Min(value = 1)
    private int quantity;

    public Socks(int cottonPart, String color, int quantity) {
        this.cottonPart = cottonPart;
        this.color = color;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Socks() {
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
