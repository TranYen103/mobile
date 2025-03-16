package com.example.do_an;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Share_RepiceActivity extends AppCompatActivity {
    Toolbar toolbar;
    Spinner spinnerCategory;
    ArrayList<String> categoryList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_repice);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Ánh xạ Spinner
        spinnerCategory = findViewById(R.id.spinner_Category);

        // Tạo danh sách loại món ăn
        categoryList = new ArrayList<>();
        categoryList.add("Chọn loại món ăn");
        categoryList.add("Món Canh");
        categoryList.add("Món Xào");
        categoryList.add("Món Nướng");
        categoryList.add("Món Hấp");
        categoryList.add("Tráng Miệng");

        // Tạo Adapter để hiển thị danh sách lên Spinner
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categoryList);
        spinnerCategory.setAdapter(adapter);

        // Xử lý sự kiện chọn Spinner
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoryList.get(position);
                if (!selectedCategory.equals("Chọn loại món ăn")) {
                    Toast.makeText(Share_RepiceActivity.this, "Bạn chọn: " + selectedCategory, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Không cần làm gì
            }
        });
    }
}
