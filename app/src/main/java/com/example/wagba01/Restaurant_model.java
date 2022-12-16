package com.example.wagba01;
import android.widget.Button;

import java.util.ArrayList;
public class Restaurant_model {
    String name;
    int image;
    Button btn;
    ArrayList<Dishes_Model> Menu = new ArrayList<Dishes_Model>();

    public Restaurant_model(String name, int image) {
        this.name = name;
        this.image = image;
    }

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








/*
    ArrayList<Dishes_Model> kfc_menu = new ArrayList<Dishes_Model>();
    kfc_menu.add(new Dishes_Model("Mighty Zinger" , "EGP120" , 1 ));
    kfc_menu.add(new Dishes_Model("Dinner Box" , "EGP80" , 2 ));
    kfc_menu.add(new Dishes_Model("Twister" , "EGP100" , 3 ));
    kfc_menu.add(new Dishes_Model("Rizo" , "EGP60" , 4 ));


    ArrayList<Dishes_Model> mac_menu = new ArrayList<Dishes_Model>();
    mac_menu.add(new Dishes_Model("Macdo" , "120EGP" , 5));
    mac_menu.add(new Dishes_Model("ShareBox" , "240EGP" , 6));
    mac_menu.add(new Dishes_Model("Big Tasty" , "100EGP" , 7));
    mac_menu.add(new Dishes_Model("Big Mac" , "80EGP" , 8));

    ArrayList<Dishes_Model> Papa_menu = new ArrayList<Dishes_Model>();
    Papa_menu.add(new Dishes_Model("Chicken Ranch Small" , "120" , 9));
    Papa_menu.add(new Dishes_Model("Chicken Ranch Medium" , "240" , 10));
    Papa_menu.add(new Dishes_Model("Chicken Ranch Large" , "290" , 11));
    Papa_menu.add(new Dishes_Model("Chicken Ranch Family" , "320" , 12));

    ArrayList<Dishes_Model> BKing_menu = new ArrayList<Dishes_Model>();
    BKing_menu.add(new Dishes_Model("Whooper" , "120" , 13));
    BKing_menu.add(new Dishes_Model("Double Whooper" , "240" , 14));
    BKing_menu.add(new Dishes_Model("Triple Whooper" , "290" , 15));
    BKing_menu.add(new Dishes_Model("Quadriple Whooper" , "320" , 16));

    ArrayList<Dishes_Model> Starbucks_menu = new ArrayList<Dishes_Model>();
    Starbucks_menu.add(new Dishes_Model("Esperesso" , "20" , 17));
    Starbucks_menu.add(new Dishes_Model("Latte" , "40" , 18));
    Starbucks_menu.add(new Dishes_Model("Tea" , "90" , 19));
    Starbucks_menu.add(new Dishes_Model("American Coffee" , "120" , 20));

    ArrayList<Dishes_Model> Sizzler = new ArrayList<Dishes_Model>();
    Sizzler.add(new Dishes_Model("Well-done" , "120" , 21));
    Sizzler.add(new Dishes_Model("Medium well" , "140" , 22));
    Sizzler.add(new Dishes_Model("Medium" , "190" , 23));
    Sizzler.add(new Dishes_Model("Rare" , "220" , 24));

    ArrayList<Dishes_Model> Hardees = new ArrayList<Dishes_Model>();
    Hardees.add(new Dishes_Model("Mushroom Burger" , "120" , 25));
    Hardees.add(new Dishes_Model("Chicken Burger" , "140" , 26));
    Hardees.add(new Dishes_Model("Beef Burger" , "190" , 27));
    Hardees.add(new Dishes_Model("Ham Burger" , "220" , 28));

    ArrayList<Dishes_Model> Costa = new ArrayList<Dishes_Model>();
    Costa.add(new Dishes_Model("Turkish Coffee" , "120" , 29));
    Costa.add(new Dishes_Model("American Coffee" , "140" , 30));
    Costa.add(new Dishes_Model("Water" , "190" , 31));
    Costa.add(new Dishes_Model("Juice" , "220" , 32));

    ArrayList<Dishes_Model> Hut = new ArrayList<Dishes_Model>();
    Hut.add(new Dishes_Model("Cheese Lovers" , "120" , 33));
    Hut.add(new Dishes_Model("Super Supreme" , "140" , 34));
    Hut.add(new Dishes_Model("Chicken Ranch" , "190" , 35));
    Hut.add(new Dishes_Model("Seafood Pizza" , "220" , 36));

    ArrayList<Dishes_Model> Attack = new ArrayList<Dishes_Model>();
    Attack.add(new Dishes_Model("Mushroom Burger" , "120" , 37));
    Attack.add(new Dishes_Model("Chicken Burger" , "140" , 38));
    Attack.add(new Dishes_Model("Beef Burger" , "190" , 39));
    Attack.add(new Dishes_Model("Ham Burger" , "220" , 40));

*/

