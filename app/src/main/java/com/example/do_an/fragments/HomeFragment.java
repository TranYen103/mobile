package com.example.do_an.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.do_an.CategoryActivity;
import com.example.do_an.FoodItem;
import com.example.do_an.R;
import com.example.do_an.SearchActivity;
import com.example.do_an.adapter.FoodAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    ImageView img_main,img_salad,img_drink,img_desert;
    EditText  edtSearch;
    RecyclerView rvsShare;
    FoodAdapter foodAdapter;
    ArrayList<FoodItem> ListFood;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvsShare = view.findViewById(R.id.rv_popular);
        edtSearch=view.findViewById(R.id.edtSearch);
        img_main=view.findViewById(R.id.img_main);
        img_drink=view.findViewById(R.id.img_drink);
        img_salad=view.findViewById(R.id.img_salad);
        img_desert=view.findViewById(R.id.img_desert);
        img_main.setOnClickListener(v -> openRecipeList("Món chính"));
        img_salad.setOnClickListener(v -> openRecipeList("Salad"));
        img_drink.setOnClickListener(v -> openRecipeList("Đồ uống"));
        img_desert.setOnClickListener(v -> openRecipeList("Tráng miệng"));
        LoadData();

        rvsShare.setLayoutManager(new LinearLayoutManager(getContext()));
        foodAdapter = new FoodAdapter(ListFood);
        rvsShare.setAdapter(foodAdapter);
        edtSearch.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        });
        return  view;
    }
    private void openRecipeList(String category) {
        Intent intent = new Intent(getActivity(), CategoryActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
    void LoadData()
    {
        ListFood = new ArrayList<>();
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-5.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));

    }

}