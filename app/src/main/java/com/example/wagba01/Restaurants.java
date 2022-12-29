package com.example.wagba01;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
    ArrayList<Restaurant_model> restaurant_models_array = new ArrayList<>();
    Button MyCart;

    int[] RestaurantsImages = {R.drawable.kfc , R.drawable.mcdonalds , R.drawable.papajohns ,
            R.drawable.burgerking , R.drawable.starbucks , R.drawable.sizzler , R.drawable.hardees ,
            R.drawable.costa , R.drawable.pizzahut , R.drawable.heartattack};

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Wagba");


    ArrayList<Dishes_Model> dishes_models = new ArrayList<>();
    int[] dishesImages = {
            R.drawable.kfc1 , R.drawable.kfc2 , R.drawable.kfc3 , R.drawable.kfc4 ,
            R.drawable.mcdonalds1 , R.drawable.mcdonalds2 , R.drawable.mcdonalds3 , R.drawable.mcdonalds4 ,
            R.drawable.papajohns1 , R.drawable.papajohns2 , R.drawable.papajohns3 , R.drawable.papajohns4 ,
            R.drawable.burgerking1 , R.drawable.burgerking2 , R.drawable.burgerking3 , R.drawable.burgerking4,
            R.drawable.starbucks1 , R.drawable.starbucks2 , R.drawable.starbucks3 , R.drawable.starbucks4,
            R.drawable.sizzler1 , R.drawable.sizzler2 , R.drawable.sizzler3 , R.drawable.sizzler4,
            R.drawable.hardees1 , R.drawable.hardees2 , R.drawable.hardees3 , R.drawable.hardees4,
            R.drawable.costa1 , R.drawable.costa2 , R.drawable.costa3 , R.drawable.costa4,
            R.drawable.pizzahut1 , R.drawable.pizzahut2 , R.drawable.pizzahut3 , R.drawable.pizzahut4,
            R.drawable.heartattack1 , R.drawable.heartattack2 , R.drawable.heartattack3 , R.drawable.heartattack4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        RecyclerView recyclerView = findViewById(R.id.restaurants_RV);

        MyCart =  findViewById(R.id.MyCartBtn);
        MyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , Cart.class);
                startActivity(intent);
            }
        });


        myRef.child("Restaurant").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    restaurant_models_array.add(postSnapshot.getValue(Restaurant_model.class));

                }

                Restaurants_RVadapter adapter = new Restaurants_RVadapter(Restaurants.this , restaurant_models_array);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Restaurants.this));

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("RT DB", "Failed to read value.", error.toException());
            }
        });

    }

    private void PopulateDatabase() {

        ArrayList<Dishes_Model> kfc_menu = new ArrayList<>();
        kfc_menu.add(new Dishes_Model("Dinner Box", "EGP120", dishesImages[0]));
        kfc_menu.add(new Dishes_Model("Rizo Combo", "EGP80", dishesImages[1]));
        kfc_menu.add(new Dishes_Model("Mighty Zinger", "EGP100", dishesImages[2]));
        kfc_menu.add(new Dishes_Model("Bucket 21pcs", "EGP350", dishesImages[3]));
        restaurant_models_array.add(new Restaurant_model("KFC", RestaurantsImages[0], kfc_menu));

        ArrayList<Dishes_Model> mac_menu = new ArrayList<>();
        mac_menu.add(new Dishes_Model("Cheese Burger", "120EGP", dishesImages[4]));
        mac_menu.add(new Dishes_Model("Chicken Macdo", "240EGP", dishesImages[5]));
        mac_menu.add(new Dishes_Model("Fries", "100EGP", dishesImages[6]));
        mac_menu.add(new Dishes_Model("Apple Pie", "80EGP", dishesImages[7]));
        restaurant_models_array.add(new Restaurant_model("McDonald's", RestaurantsImages[1], mac_menu));

        ArrayList<Dishes_Model> Papa_menu = new ArrayList<>();
        Papa_menu.add(new Dishes_Model("Chicken Ranch ", "EGP120", dishesImages[8]));
        Papa_menu.add(new Dishes_Model("Peperoni", "EGP240", dishesImages[9]));
        Papa_menu.add(new Dishes_Model("Chicken Ranch Large", "EGP290", dishesImages[10]));
        Papa_menu.add(new Dishes_Model("Chicken Ranch Family", "EGP320", dishesImages[11]));
        restaurant_models_array.add(new Restaurant_model("Papa John's", RestaurantsImages[2], Papa_menu));

        ArrayList<Dishes_Model> BKing_menu = new ArrayList<>();
        BKing_menu.add(new Dishes_Model("Whooper", "EGP120", dishesImages[12]));
        BKing_menu.add(new Dishes_Model("Double Whooper", "EGP240", dishesImages[13]));
        BKing_menu.add(new Dishes_Model("Triple Whooper", "EGP290", dishesImages[14]));
        BKing_menu.add(new Dishes_Model("Cheese Burger", "EGP80", dishesImages[15]));
        restaurant_models_array.add(new Restaurant_model("Burger King", RestaurantsImages[3], BKing_menu));

        ArrayList<Dishes_Model> Starbucks_menu = new ArrayList<>();
        Starbucks_menu.add(new Dishes_Model("Caramel Coffee", "EGP20", dishesImages[16]));
        Starbucks_menu.add(new Dishes_Model("Latte", "EGP40", dishesImages[17]));
        Starbucks_menu.add(new Dishes_Model("Tea", "EGP90", dishesImages[18]));
        Starbucks_menu.add(new Dishes_Model("Strawberry Coffee", "120", dishesImages[19]));
        restaurant_models_array.add(new Restaurant_model("Starbucks", RestaurantsImages[4], Starbucks_menu));

        ArrayList<Dishes_Model> Sizzler = new ArrayList<>();
        Sizzler.add(new Dishes_Model("Well-done", "EGP120", dishesImages[20]));
        Sizzler.add(new Dishes_Model("Medium well", "EGP140", dishesImages[21]));
        Sizzler.add(new Dishes_Model("Medium rare", "EGP190", dishesImages[22]));
        Sizzler.add(new Dishes_Model("Rare", "EGP220", dishesImages[23]));
        restaurant_models_array.add(new Restaurant_model("Sizzler", RestaurantsImages[5], Sizzler));


        ArrayList<Dishes_Model> Hardees = new ArrayList<>();
        Hardees.add(new Dishes_Model("Mushroom Burger", "EGP120", dishesImages[24]));
        Hardees.add(new Dishes_Model("Chicken Burger", "EGP140", dishesImages[25]));
        Hardees.add(new Dishes_Model("Beef Burger", "EGP190", dishesImages[26]));
        Hardees.add(new Dishes_Model("Ham Burger", "EGP220", dishesImages[27]));
        restaurant_models_array.add(new Restaurant_model("Hardees", RestaurantsImages[6], Hardees));

        ArrayList<Dishes_Model> Costa = new ArrayList<>();
        Costa.add(new Dishes_Model("Turkish Coffee", "EGP20", dishesImages[28]));
        Costa.add(new Dishes_Model("American Coffee", "EGP40", dishesImages[29]));
        Costa.add(new Dishes_Model("Latte", "EGP50", dishesImages[30]));
        Costa.add(new Dishes_Model("Cappuccino", "EGP60", dishesImages[31]));
        restaurant_models_array.add(new Restaurant_model("Costa", RestaurantsImages[7], Costa));

        ArrayList<Dishes_Model> Hut = new ArrayList<>();
        Hut.add(new Dishes_Model("Cheese Lovers", "EGP120", dishesImages[32]));
        Hut.add(new Dishes_Model("Super Supreme", "EGP140", dishesImages[33]));
        Hut.add(new Dishes_Model("Chicken Ranch", "EGP190", dishesImages[34]));
        Hut.add(new Dishes_Model("Family Pizza", "EGP220", dishesImages[35]));
        restaurant_models_array.add(new Restaurant_model("Pizza Hut", RestaurantsImages[8], Hut));

        ArrayList<Dishes_Model> Attack = new ArrayList<>();
        Attack.add(new Dishes_Model("Mushroom Burger", "EGP120", dishesImages[36]));
        Attack.add(new Dishes_Model("Chicken Burger", "EGP140", dishesImages[37]));
        Attack.add(new Dishes_Model("Beef Burger", "EGP190", dishesImages[38]));
        Attack.add(new Dishes_Model("Heart Attack Brgr", "EGP220", dishesImages[39]));
        restaurant_models_array.add(new Restaurant_model("Heart Attack", RestaurantsImages[9], Attack));

        myRef.child("Restaurant").setValue(restaurant_models_array);

    }
}


