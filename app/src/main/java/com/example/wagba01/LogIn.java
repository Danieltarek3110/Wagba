package com.example.wagba01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;

public class LogIn extends AppCompatActivity {

    EditText userEmail , userPassword;
    Button loginbtn;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        userEmail = findViewById(R.id.EmailAddress01);
        userPassword = findViewById(R.id.Password01);
        loginbtn = findViewById(R.id.button_login01);

        mAuth = FirebaseAuth.getInstance();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String Email = userEmail.getText().toString();
        String pass = userPassword.getText().toString();
        if(TextUtils.isEmpty(Email)){
            userEmail.setError("Email field cannot be empty");
            userEmail.requestFocus();
        }else if(TextUtils.isEmpty(pass)){
            userPassword.setError("Password field cannot be empty");
            userPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(Email , pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LogIn.this, "Logging in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogIn.this, Restaurants.class));
                    } else {
                        Toast.makeText(LogIn.this, "Log in Error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    }

