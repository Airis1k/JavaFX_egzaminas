package com.example.javafx_dakar.model;

public class Restaurant {
    private int id;
    private String name;
    private String code;
    private String address;
    private String foodType;
    private String dishName;
    private String dishText;
    private int userId;

    public Restaurant(int id, String name, String code, String address, String foodType, String dishName, String dishText) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
        this.foodType = foodType;
        this.dishName = dishName;
        this.dishText = dishText;
    }

    public Restaurant(String name, String code, String address, String foodType, String dishName, String dishText) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.foodType = foodType;
        this.dishName = dishName;
        this.dishText = dishText;
    }

    public Restaurant(String name, String code, String address, String foodType, String dishName, String dishText, int userId) {
        this.name = name;
        this.code = code;
        this.address = address;
        this.foodType = foodType;
        this.dishName = dishName;
        this.dishText = dishText;
        this.userId = userId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishText() {
        return dishText;
    }

    public void setDishText(String dishText) {
        this.dishText = dishText;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", foodType='" + foodType + '\'' +
                ", dishName='" + dishName + '\'' +
                ", dishText='" + dishText + '\'' +
                ", userId=" + userId +
                '}';
    }
}
