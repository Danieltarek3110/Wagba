package com.example.wagba01;

import static com.example.wagba01.R.id.R_recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wagba01.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent intent01 , intent02, intent03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        intent01 = new Intent(this, SignUp.class);
        intent02 = new Intent(this, LogIn.class);
        intent03 = new Intent(this, Restaurants.class);

        binding.btnSignUp.setOnClickListener(view1 -> startActivity(intent01));
        binding.btnSignIn.setOnClickListener(view12 -> startActivity(intent02));
        binding.testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent03);
            }
        });



    }


}