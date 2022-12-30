package com.example.wagba01;

import java.util.ArrayList;

public class Orders_Model {

    String TrackingNumber;
    String State;
    String Price;
    ArrayList<Orders_Model> orders_models = new ArrayList<>();


    public Orders_Model() {
    }

    public Orders_Model(String trackingNumber, String state, String price, ArrayList<Orders_Model> orders_models) {
        TrackingNumber = trackingNumber;
        State = state;
        Price = price;
        this.orders_models = orders_models;
    }

    public Orders_Model(String trackingNumber, String state, String price) {
        TrackingNumber = trackingNumber;
        State = state;
        Price = price;
    }

    public String getTrackingNumber() {
        return TrackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        TrackingNumber = trackingNumber;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public ArrayList<Orders_Model> getOrders_models() {
        return orders_models;
    }

    public void setOrders_models(ArrayList<Orders_Model> orders_models) {
        this.orders_models = orders_models;
    }
}
