package com.example.wagba01;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
public class Restaurant_model implements Serializable {
    String name;
    int id;
    int image;
    Button btn;
    ArrayList<Dishes_Model> Menu = new ArrayList<>();

    public Restaurant_model(String name, int image, ArrayList<Dishes_Model> menu) {
        this.name = name;
        this.image = image;
        Menu = menu;
    }

    public Restaurant_model(String name, int image, Button btn, ArrayList<Dishes_Model> menu) {
        this.name = name;
        this.image = image;
        this.btn = btn;
        Menu = menu;
    }

    public Restaurant_model() {
    }

    public Restaurant_model(String name, int id, int image, Button btn, ArrayList<Dishes_Model> menu) {
        this.name = name;
        this.id = id;
        this.image = image;
        this.btn = btn;
        Menu = menu;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<Dishes_Model> getMenu() {
        return Menu;
    }

    public void setMenu(ArrayList<Dishes_Model> menu) {
        Menu = menu;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}

