package com.example.wagba01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wagba01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Intent intent01 , intent02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.wagba01.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        intent01 = new Intent(this, SignUp.class);
        intent02 = new Intent(this, LogIn.class);

        binding.btnSignUp.setOnClickListener(view1 -> startActivity(intent01));

        binding.btnSignIn.setOnClickListener(view12 -> startActivity(intent02));

    }
}