package com.example.do_an;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.do_an.adapter.FoodAdapter;
import com.example.do_an.fragments.Category_ViewFragment;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity{
    Toolbar toolbar;

    FoodAdapter foodAdapter;
    ArrayList<FoodItem> ListFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_category);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.Toolbar_category);

       loadCategoryFragment();





    }
    private void loadCategoryFragment() {
        Fragment fragment = new Category_ViewFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.Frame_Category, fragment);
        transaction.commit();
    }


}