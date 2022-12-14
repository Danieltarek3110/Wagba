package com.example.wagba01;

public class Restaurant_model {
    String name;
    String delivery;
    int image;

    public Restaurant_model(String name, String delivery, int image) {
        this.name = name;
        this.delivery = delivery;
        this.image = image;
    }

    public Restaurant_model(String name) {
        this.name = name;
    }

    public Restaurant_model(String name, int image) {
        this.name = name;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public String getDelivery() {
        return delivery;
    }

    public int getImage() {
        return image;
    }
}
