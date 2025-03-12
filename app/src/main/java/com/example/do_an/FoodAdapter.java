package com.example.do_an;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    Context context;
    ArrayList<FoodItem> listFood;

    public FoodAdapter(ArrayList<FoodItem> listFood) {
        this.listFood = listFood;
    }


    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nap layout cho view bieu dien phan tu user
        View foodView = inflater.inflate(R.layout.foodsave, parent, false);


        FoodViewHolder foodViewHolder = new FoodViewHolder(foodView);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        FoodItem foodItem = listFood.get(position);

        holder.foodImg.setImageBitmap(Utils.convertToBitmapFromAssets(context,foodItem.getImage()));
        holder.foodName.setText(foodItem.getTittle());
        holder.foodDes.setText(foodItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImg;
        TextView foodName, foodDes;
        ImageButton btbSave;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.Item_Name);
            foodImg = itemView.findViewById(R.id.Item_Img);
            foodDes = itemView.findViewById(R.id.CongThuc);
            btbSave = itemView.findViewById(R.id.btnSave);

        }
    }
}

