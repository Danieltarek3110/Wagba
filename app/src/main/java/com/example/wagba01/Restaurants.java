package com.example.wagba01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
    ArrayList<Restaurant_model> restaurant_models_array = new ArrayList<>();



    int[] RestaurantsImages = {R.drawable.kfc , R.drawable.mcdonalds , R.drawable.papajohns ,
            R.drawable.burgerking , R.drawable.starbucks , R.drawable.sizzler , R.drawable.hardees ,
            R.drawable.costa , R.drawable.pizzahut , R.drawable.heartattack};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        RecyclerView recyclerView = findViewById(R.id.restaurants_RV);
        SetUpRestaurantModels();
        Restaurants_RVadapter adapter = new Restaurants_RVadapter(this , restaurant_models_array);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void SetUpRestaurantModels(){
        String[] RestaurantModelsNames = getResources().getStringArray(R.array.RestaurantsNames);

        for(int i=0; i<RestaurantModelsNames.length ; i++){
            restaurant_models_array.add(new Restaurant_model(RestaurantModelsNames[i],RestaurantsImages[i]));

        }
    }

}