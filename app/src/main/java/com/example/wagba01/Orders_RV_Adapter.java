package com.example.wagba01;

import static com.example.wagba01.R.layout.orders_row;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Orders_RV_Adapter extends RecyclerView.Adapter<Orders_RV_Adapter.MyViewHolder> {

    Context context; ArrayList<Orders_Model> orders_models;

    public Orders_RV_Adapter(Context context , ArrayList<Orders_Model> orders_models){
        this.context = context;
        this.orders_models = orders_models;

    }



    @NonNull
    @Override
    public Orders_RV_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.orders_row , parent , false);


        return new Orders_RV_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Orders_RV_Adapter.MyViewHolder holder, int position) {

        holder.OrderPrice.setText(orders_models.get(position).getPrice());
        holder.OrderState.setText(orders_models.get(position).getState());
        holder.OrderTrackingNum.setText(orders_models.get(position).getTrackingNumber());


    }

    @Override
    public int getItemCount() {
        return orders_models.size();
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView OrderTrackingNum , OrderState , OrderPrice;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            OrderTrackingNum = itemView.findViewById(R.id.OrderTracking);
            OrderState = itemView.findViewById(R.id.OrderState);
            OrderPrice = itemView.findViewById(R.id.OrderPrice);

        }
    }






}
