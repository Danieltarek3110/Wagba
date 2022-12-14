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

public class Dishes_RV_Adapter extends RecyclerView.Adapter<Dishes_RV_Adapter.MyViewHolder> {

    Context context; ArrayList<Dishes_Model> dishes_models;

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
    public void onBindViewHolder(@NonNull Dishes_RV_Adapter.MyViewHolder holder, int position) {

        holder.tvName.setText(dishes_models.get(position).getDishName());
        holder.tvPrice.setText(dishes_models.get(position).DishPrice);
        holder.imageView.setImageResource(dishes_models.get(position).getDishImage());


    }

    @Override
    public int getItemCount() {
        return dishes_models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName , tvPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewdishRow);
            tvName = itemView.findViewById(R.id.textViewDishName);
            tvPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
