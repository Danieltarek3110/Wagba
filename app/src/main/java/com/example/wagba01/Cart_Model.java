package com.example.wagba01;

public class Cart_Model {

    String CartDishName;
    String CartDishPrice;
    int CartDishImage;


    public Cart_Model(String cartDishName, String cartDishPrice, int cartDishImage) {
        CartDishName = cartDishName;
        CartDishPrice = cartDishPrice;
        CartDishImage = cartDishImage;
    }

    public Cart_Model() {
    }

    public String getCartDishName() {
        return CartDishName;
    }

    public void setCartDishName(String cartDishName) {
        CartDishName = cartDishName;
    }

    public String getCartDishPrice() {
        return CartDishPrice;
    }

    public void setCartDishPrice(String cartDishPrice) {
        CartDishPrice = cartDishPrice;
    }

    public int getCartDishImage() {
        return CartDishImage;
    }

    public void setCartDishImage(int cartDishImage) {
        CartDishImage = cartDishImage;
    }
}
