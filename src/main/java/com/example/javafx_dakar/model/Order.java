package com.example.javafx_dakar.model;

public class Order {
    private int id;
    private String name;
    private String dishName;
    private int quantity;

    public Order(String name, String dishName, int quantity) {
        this.name = name;
        this.dishName = dishName;
        this.quantity = quantity;
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

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dishName='" + dishName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
