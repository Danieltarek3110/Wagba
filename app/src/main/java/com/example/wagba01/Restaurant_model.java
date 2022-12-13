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
