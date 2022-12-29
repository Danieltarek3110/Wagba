package com.example.wagba01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Cart_RV_Adapter extends RecyclerView.Adapter<Cart_RV_Adapter.MyViewHolder> {

    Context context;
    ArrayList<Cart_Model> cart_models;

//
//    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
//    DatabaseReference myRef = database.getReference("Wagba");


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

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewCartRow);
            textViewDishName = itemView.findViewById(R.id.textViewCartName);
            textViewDishPrice = itemView.findViewById(R.id.textViewCartPrice);


        }
    }



}
