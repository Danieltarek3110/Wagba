package com.example.wagba01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wagba01.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Intent intent01 , intent02, intent03;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        intent01 = new Intent(this, SignUp.class);
        intent02 = new Intent(this, LogIn.class);
        intent03 = new Intent(this, Restaurants.class);
        mAuth = FirebaseAuth.getInstance();

        binding.btnSignUp.setOnClickListener(view1 -> startActivity(intent01));
        binding.btnSignIn.setOnClickListener(view12 -> startActivity(intent02));
        binding.testbtn.setOnClickListener(v -> startActivity(intent03));
    }

    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser user = mAuth.getCurrentUser();
        if(user==null){
            startActivity(new Intent(MainActivity.this , SignUp.class));
        }
    }

}