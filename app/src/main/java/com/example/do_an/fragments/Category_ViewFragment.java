package com.example.do_an.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.do_an.adapter.FoodAdapter;
import com.example.do_an.FoodItem;
import com.example.do_an.R;

import java.util.ArrayList;


public class Category_ViewFragment extends Fragment {
    RecyclerView rvsCategory;
    FoodAdapter foodAdapter;
    ArrayList<FoodItem> ListFood;


    public Category_ViewFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category__view, container, false);

        rvsCategory = view.findViewById(R.id.rcv_Category);
        String category = getArguments().getString("category", "Món chính");
        Toast.makeText(getContext(), "Loại món ăn: " + category, Toast.LENGTH_SHORT).show();

        LoadData();
        LoadData(category);

        rvsCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        foodAdapter= new FoodAdapter(ListFood);
        rvsCategory.setAdapter(foodAdapter);
        return view;
    }
    void LoadData(String category) {
        ListFood = new ArrayList<>();

        if (category.equals("Món chính")) {
            ListFood.add(new FoodItem("Bò lúc lắc", "Thịt bò mềm thơm ngon", "bo.jpg"));
            ListFood.add(new FoodItem("Cơm gà", "Cơm gà giòn rụm", "comga.jpg"));
        } else if (category.equals("Salad")) {
            ListFood.add(new FoodItem("Salad trộn", "Rau củ tươi ngon", "saladtron.jpg"));
            ListFood.add(new FoodItem("Salad cá hồi", "Cá hồi với sốt chanh dây", "saladcahoi.jpg"));
        } else if (category.equals("Đồ uống")) {
            ListFood.add(new FoodItem("Trà sữa", "Trà sữa trân châu đường đen", "trasua.jpg"));
            ListFood.add(new FoodItem("Nước cam", "Nước cam ép tươi", "nuoccam.jpg"));
        } else if (category.equals("Tráng miệng")) {
            ListFood.add(new FoodItem("Bánh flan", "Bánh flan mềm mịn", "banhflan.jpg"));
            ListFood.add(new FoodItem("Chè bưởi", "Chè bưởi ngọt thanh", "chebuoi.jpg"));
        }
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