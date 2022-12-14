package com.example.wagba01;

import static com.example.wagba01.R.id.restaurants_RV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.wagba01.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity {
    ArrayList<Restaurant_model> restaurant_models = new ArrayList<>();
    int[] RestaurantsImages = {R.drawable.kfc , R.drawable.mcdonalds , R.drawable.papajohns , R.drawable.burgerking , R.drawable.starbucks ,
            R.drawable.sizzler , R.drawable.hardees , R.drawable.costa , R.drawable.pizzahut , R.drawable.heartattack};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        RecyclerView recyclerView ;
        recyclerView = findViewById(R.id.restaurants_RV);


        setuprestaurantmodels();

        Restaurants_RVadapter adapter = new Restaurants_RVadapter(this , restaurant_models);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setContentView(R.layout.activity_restaurants);
    }
    private void setuprestaurantmodels(){
        String[] restaurantmodelsNames = getResources().getStringArray(R.array.RestaurantsNames);

        for(int i=0 ; i< restaurantmodelsNames.length ; i++){
            restaurant_models.add(new Restaurant_model(restaurantmodelsNames[i],RestaurantsImages[i]));

        }
    }

}