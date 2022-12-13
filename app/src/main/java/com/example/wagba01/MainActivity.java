package com.example.wagba01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wagba01.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent intent01 , intent02;
    ArrayList<Restaurant_model> restaurant_models = new ArrayList<>();
    int[] RestaurantsImages = {R.drawable.ic_menu_send};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intent01 = new Intent(this, SignUp.class);
        intent02 = new Intent(this, LogIn.class);

        binding.btnSignUp.setOnClickListener(view1 -> startActivity(intent01));

        binding.btnSignIn.setOnClickListener(view12 -> startActivity(intent02));

    }

    private void setuprestaurantmodels(){
        String[] restaurantmodels = getResources().getStringArray(R.array.RestaurantsNames);

        for(int i=0 ; i< restaurantmodels.length ; i++){
            restaurant_models.add(new Restaurant_model(restaurantmodels[i]));
        }
    }
}