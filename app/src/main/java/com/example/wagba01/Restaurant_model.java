package com.example.wagba01;

public class Restaurant_model {
    String name;
    int image;

    public Restaurant_model(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public Restaurant_model(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
