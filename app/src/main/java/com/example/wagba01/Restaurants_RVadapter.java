package com.example.wagba01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Restaurants_RVadapter extends RecyclerView.Adapter<Restaurants_RVadapter.MyViewHolder> {
    Context context;
    ArrayList<Restaurant_model> restaurant_models;

    public Restaurants_RVadapter(Context context , ArrayList<Restaurant_model> restaurant_models){
        this.context = context;
        this.restaurant_models = restaurant_models;
    }


    @NonNull
    @Override
    public Restaurants_RVadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.restaurants_recyclerview_row , parent);
        return new Restaurants_RVadapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Restaurants_RVadapter.MyViewHolder holder, int position) {
        holder.textView.setText(restaurant_models.get(position).getName());
        holder.imageView.setImageResource(restaurant_models.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return restaurant_models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewRow);
            textView = itemView.findViewById(R.id.textViewRow);
        }



    }
}
