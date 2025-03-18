package com.example.do_an.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_an.RecipeActivity;
import com.example.do_an.SearchItem;
import com.example.do_an.R;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<SearchItem> arrayList;
    LayoutInflater layoutInflater;

    public SearchAdapter(Context context, ArrayList<SearchItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.search_rv,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.SearchViewHolder holder, int position) {
        SearchItem item = arrayList.get(position);
holder.foodName.setText(arrayList.get(position).getFoodName());
holder.img.setImageResource(arrayList.get(position).getImg());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("foodName", item.getFoodName());
            intent.putExtra("foodImage", item.getImg());
            context.startActivity(intent);});
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView foodName;
        ImageView img;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName=itemView.findViewById(R.id.demotxt);
            img=itemView.findViewById(R.id.img);
        }
    }
}
