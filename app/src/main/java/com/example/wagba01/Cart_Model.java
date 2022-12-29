package com.example.wagba01;

public class Cart_Model {

    String DishName;
    String DishPrice;
    int DishImage;

    public Cart_Model(String dishName, String dishPrice, int dishImage) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
    }

    public Cart_Model() {
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public String getDishPrice() {
        return DishPrice;
    }

    public void setDishPrice(String dishPrice) {
        DishPrice = dishPrice;
    }

    public int getDishImage() {
        return DishImage;
    }

    public void setDishImage(int dishImage) {
        DishImage = dishImage;
    }
}
