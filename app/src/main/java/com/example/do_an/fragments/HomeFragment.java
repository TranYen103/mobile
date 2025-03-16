package com.example.do_an.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.do_an.R;


public class HomeFragment extends Fragment {
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

        LoadData();

        rvsShare.setLayoutManager(new LinearLayoutManager(getContext()));
        foodAdapter = new FoodAdapter(ListFood);
        rvsShare.setAdapter(foodAdapter);

        return  view;
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