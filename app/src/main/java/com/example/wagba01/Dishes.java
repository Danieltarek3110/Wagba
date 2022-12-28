package com.example.wagba01;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Dishes extends AppCompatActivity {
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
        setContentView(R.layout.activity_dishes);

        Bundle extra = getIntent().getBundleExtra("extra");
        dishes_models = (ArrayList<Dishes_Model>) extra.getSerializable("menu");



        RecyclerView recyclerView = findViewById(R.id.Dishes_RV);
        Dishes_RV_Adapter adapter = new Dishes_RV_Adapter(this, dishes_models);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}



// FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
// DatabaseReference DishRef = database.getReference("Wagba" ).child("Restaurant");

/*

        int id = (int) extra.get("RestaurantId");
        DishRef.child(String.valueOf(id)).child("menu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    dishes_models.add(postSnapshot.getValue(Dishes_Model.class));
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/


/*
    private void SetUpDishesModel(){
        String[] dishesNames = getResources().getStringArray(R.array.DishNames);
        String[] dishesPrices = getResources().getStringArray(R.array.DishPrices);
        for(int i=0 ; i< dishesNames.length ; i++){
            dishes_models.add(new Dishes_Model(dishesNames[i], dishesPrices[i] , dishesImages[i] ));
        }

    }

*/