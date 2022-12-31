package com.example.wagba01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Orders extends AppCompatActivity {

    ArrayList<Orders_Model> orders_models = new ArrayList<>();


    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference OrdersRef = database.getReference("Wagba");
    FirebaseAuth UserAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);


        RecyclerView recyclerView = findViewById(R.id.OrdersRecyclerView);

        UserAuth = FirebaseAuth.getInstance() ;
        String UId = Objects.requireNonNull(UserAuth.getCurrentUser()).getUid() ;

        OrdersRef.child("user").child(UId).child("orders").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Log.d("Orderrrr" , orders_models.toString());
                    orders_models.add(postSnapshot.getValue(Orders_Model.class));
                }




                Orders_RV_Adapter adapter = new Orders_RV_Adapter(Orders.this, orders_models);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Orders.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("RT DB", "Failed to read value.", error.toException());
            }
        });


    }


}