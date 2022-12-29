package com.example.wagba01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    EditText Fname , Lname , usrEmail , usrpassword;
    Button registerbtn , Already_A_Member;
    FirebaseAuth mAuth;
    DatabaseReference CartDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        CartDatabase = FirebaseDatabase.getInstance().getReference();

        Fname = findViewById(R.id.FirstName01);
        Lname = findViewById(R.id.LastName02);
        usrEmail = findViewById(R.id.EmailAddress01);
        usrpassword = findViewById(R.id.Password01);
        registerbtn = findViewById(R.id.button_login01);
        Already_A_Member = findViewById(R.id.LoginHereBtn);

        Already_A_Member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this , LogIn.class));
            }
        });

        mAuth = FirebaseAuth.getInstance();
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

    }
    private void createUser(){

        String Email = usrEmail.getText().toString();
        String FirstName = Fname.getText().toString();
        String LastName = Lname.getText().toString();
        String pass = usrpassword.getText().toString();
        UserModel userModel= new UserModel();
        userModel.setFirstName(FirstName);
        userModel.setLastName(LastName);


        if(TextUtils.isEmpty(Email)){
            usrEmail.setError("Email field cannot be empty");
            usrEmail.requestFocus();

        }else if(TextUtils.isEmpty(pass)){
            usrpassword.setError("Password field cannot be empty");
            usrpassword.requestFocus();
        }else{
            DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(userModel);
            mAuth.createUserWithEmailAndPassword(Email , pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(SignUp.this , "User Registered successfully" , Toast.LENGTH_SHORT).show();

                        String UserId = Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid() ;
                        FirebaseDatabase.getInstance().getReference("Wagba").child("user").setValue(UserId);

                        startActivity(new Intent(SignUp.this , LogIn.class));
                    }else{
                        Toast.makeText(SignUp.this , "Registration Error: " + Objects.requireNonNull(task.getException()).getMessage() , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

}