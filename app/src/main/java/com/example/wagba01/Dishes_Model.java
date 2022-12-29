package com.example.wagba01;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Dishes_Model implements Serializable {
    String DishName;
    String DishPrice;
    int DishImage;
    Button AddToCart;

    public Dishes_Model(String dishName, String dishPrice, int dishImage, Button addToCart) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
        AddToCart = addToCart;
    }

    public Dishes_Model(String dishName, String dishPrice, int dishImage) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
    }

    public Dishes_Model() {
    }


    public String getDishName() {
        return DishName;
    }

    public String getDishPrice() {
        return DishPrice;
    }

    public int getDishImage() {
        return DishImage;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public void setDishPrice(String dishPrice) {
        DishPrice = dishPrice;
    }

    public void setDishImage(int dishImage) {
        DishImage = dishImage;
    }

    public Button getAddToCart() {
        return AddToCart;
    }

    public void setAddToCart(Button addToCart) {
        AddToCart = addToCart;
    }




}
