package com.example.wagba01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Cart_RV_Adapter extends RecyclerView.Adapter<Cart_RV_Adapter.MyViewHolder> {

    Context context;
    ArrayList<Cart_Model> cart_models;


    public  Cart_RV_Adapter(Context context , ArrayList<Cart_Model> cart_models){
        this.context = context;
        this.cart_models = cart_models;

    }

    @NonNull
    @Override
    public Cart_RV_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cart_rv_row , parent , false);

        return new Cart_RV_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_RV_Adapter.MyViewHolder holder, int position) {

        holder.textViewDishName.setText(cart_models.get(position).getDishName());
        holder.textViewDishPrice.setText(cart_models.get(position).getDishPrice());
        holder.imageView.setImageResource(cart_models.get(position).getDishImage());




    }

    @Override
    public int getItemCount() {
        return cart_models.size();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView textViewDishName;
        TextView textViewDishPrice;
        Button rmv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewOrderRow);
            textViewDishName = itemView.findViewById(R.id.OrderTracking);
            textViewDishPrice = itemView.findViewById(R.id.OrderPrice);
            rmv = itemView.findViewById(R.id.RemoveFromCart);


        }
    }



}














/*
        holder.rmv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference userRef = database.getReference("user"); // Wagba
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid() ;
                userRef.child(uid).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        if(!task.isSuccessful()){
                            Log.e("firebase" , "Error retrieving data" , task.getException());
                        }else{
                            Log.d("firebase" , String.valueOf(task.getResult().getValue()));
                            ArrayList<Cart_Model> cart = new ArrayList<>();
                            for(DataSnapshot ds : task.getResult().child("cart").getChildren() ){
                                Cart_Model item = ds.getValue(Cart_Model.class);
                                cart.add(item);
                            }
                            ArrayList<Orders_Model> history = new ArrayList<>();
                            for (DataSnapshot ds : task.getResult().child("ordersHistory").getChildren()) {
                                Orders_Model item = ds.getValue(Orders_Model.class);
                                history.add(item);
                            }

                            UserModel currentUser = new UserModel(
                                    task.getResult().child("email").getValue(String.class),
                                    task.getResult().child("name").getValue(String.class), cart, history);
                            currentUser.getCart().remove(viewHolder.getAdapterPosition());
                            userRef.child(uid).setValue(currentUser);



                        }
                    }
                });

            }

        });
*/

