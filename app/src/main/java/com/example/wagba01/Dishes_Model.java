package com.example.wagba01;

import android.widget.ImageView;
import android.widget.TextView;

public class Dishes_Model {
    String DishName;
    String DishPrice;
    int DishImage;


    public Dishes_Model(String dishName, String dishPrice, int dishImage) {
        DishName = dishName;
        DishPrice = dishPrice;
        DishImage = dishImage;
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
}
