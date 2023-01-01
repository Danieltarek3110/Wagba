package com.example.wagba01;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class Cart extends AppCompatActivity {


    ArrayList<Cart_Model> inCart = new ArrayList<>();
    ArrayList<Orders_Model> order = new ArrayList<>();


    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference CartRef = database.getReference("Wagba");
    FirebaseAuth UserNode;

    Button PlaceOrder;
    TextView CartTotalTxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        RecyclerView recyclerView = findViewById(R.id.CartRecyclerView);

        PlaceOrder = findViewById(R.id.PlaceOrderBtn);
        CartTotalTxt = findViewById(R.id.CartTotal);

        UserNode = FirebaseAuth.getInstance() ;
        String UserId = UserNode.getCurrentUser().getUid() ;



        CartRef.child("user").child(UserId).child("cart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int CartTotal = 0;


                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    inCart.add(postSnapshot.getValue(Cart_Model.class));

                    String totalPrice =postSnapshot.child("dishPrice").getValue().toString();
                    totalPrice = (totalPrice).substring(3, totalPrice.length());
                    CartTotal += Integer.parseInt(totalPrice);
                    Log.d("CartTotal" , String.valueOf(CartTotal));

                    CartTotalTxt.setText(String.valueOf(CartTotal));
                }


                int finalCartTotal = CartTotal;
                PlaceOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), Orders.class);

                        DatabaseReference OrdersRef = CartRef.child("user").child(Objects.requireNonNull(UserNode.getUid())).child("orders").push();
                        OrdersRef.setValue(new Orders_Model("Setting Tracking Number" , "Pending Approval" , String.valueOf(finalCartTotal)));

                        DatabaseReference Tracking = CartRef.child("Track").push();
                        Tracking.setValue(new Orders_Model("Setting Tracking Number" , "Pending Approval" , String.valueOf(finalCartTotal)));

                        v.getContext().startActivity(intent);
                    }
                });


                Cart_RV_Adapter adapter = new Cart_RV_Adapter(Cart.this , inCart);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Cart.this));


            }






            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("RT DB", "Failed to read value.", error.toException());
            }
        });



    }























}