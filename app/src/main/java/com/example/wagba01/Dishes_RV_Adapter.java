package com.example.wagba01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Dishes_RV_Adapter extends RecyclerView.Adapter<Dishes_RV_Adapter.MyViewHolder> {

    Context context; ArrayList<Dishes_Model> dishes_models;


    FirebaseDatabase database = FirebaseDatabase.getInstance("https://wagba01-default-rtdb.europe-west1.firebasedatabase.app/");
    DatabaseReference myRef = database.getReference("Wagba");
    FirebaseUser userRef = FirebaseAuth.getInstance().getCurrentUser();





    public Dishes_RV_Adapter(Context context , ArrayList<Dishes_Model> dishes_models){
        this.context = context;
        this.dishes_models = dishes_models;
    }

    @NonNull
    @Override
    public Dishes_RV_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dish_row , parent , false);
        return new Dishes_RV_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // position = holder.getAbsoluteAdapterPosition();
        holder.tvName.setText(dishes_models.get(position).getDishName());
        holder.tvPrice.setText(dishes_models.get(position).getDishPrice());
        holder.imageView.setImageResource(dishes_models.get(position).getDishImage());
        holder.AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Cart.class);

                DatabaseReference cartRef = myRef.child("user").child(userRef.getUid()).child("cart").push();
                cartRef.setValue(new Dishes_Model(dishes_models.get(holder.getAbsoluteAdapterPosition()).getDishName(),
                        dishes_models.get(holder.getAbsoluteAdapterPosition()).getDishPrice(),
                        dishes_models.get(holder.getAbsoluteAdapterPosition()).getDishImage() ));


                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes_models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName , tvPrice;
        Button AddToCart;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewOrderRow);
            tvName = itemView.findViewById(R.id.OrderTracking);
            tvPrice = itemView.findViewById(R.id.OrderPrice);
            AddToCart = itemView.findViewById(R.id.AddToCartBtn);

        }
    }


}
