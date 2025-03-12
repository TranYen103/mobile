package com.example.do_an.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.do_an.FoodAdapter;
import com.example.do_an.FoodItem;
import com.example.do_an.R;

import java.util.ArrayList;
import java.util.List;


public class shareFragment extends Fragment {
    RecyclerView rvsShare;
    FoodAdapter foodAdapter;
    ArrayList<FoodItem> ListFood;

    public shareFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share, container, false);

        rvsShare = view.findViewById(R.id.rcv_share);

        LoadData();

       rvsShare.setLayoutManager(new LinearLayoutManager(getContext()));
       foodAdapter= new FoodAdapter(ListFood);
       rvsShare.setAdapter(foodAdapter);

        return  view;
    }
    void LoadData()
    {
        ListFood = new ArrayList<>();
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf5.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));
        ListFood.add(new FoodItem("Món 1", "ngom quá dễ lamfdef", "cf-1.jpg"));




    }


}