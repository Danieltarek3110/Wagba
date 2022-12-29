package com.example.wagba01;

import android.widget.Button;

public class Cart_Model {

    String DishName;
    String DishPrice;
    int DishImage;
    Button Rmv;

    public Cart_Model(String dishName, String dishPrice, int dishImage) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
    }

    public Cart_Model() {
    }

    public Cart_Model(String dishName, String dishPrice, int dishImage, Button rmv) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
        Rmv = rmv;
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

    public Button getRmv() {
        return Rmv;
    }

    public void setRmv(Button rmv) {
        Rmv = rmv;
    }
}
