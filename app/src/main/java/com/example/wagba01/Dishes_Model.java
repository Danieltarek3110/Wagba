package com.example.wagba01;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Dishes_Model implements Serializable {
    String DishName;
    String DishPrice;
    int DishImage;


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
}
