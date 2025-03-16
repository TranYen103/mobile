package com.example.do_an;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.example.do_an.adapter.RecipeAdapter;
import com.google.android.material.tabs.TabLayout;

public class RecipeActivity extends AppCompatActivity {
    ImageView back,delete;
TabLayout tabLayout;
ViewPager2 viewPager2;
RecipeAdapter recipeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        tabLayout=findViewById(R.id.tab_layout);
        viewPager2=findViewById(R.id.view_pager);
        recipeAdapter=new RecipeAdapter(this);
        viewPager2.setAdapter(recipeAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
        back=findViewById(R.id.back);
        delete=findViewById(R.id.delete);
        handleEvent();
    }

    private void handleEvent() {
        back.setOnClickListener(view -> finish());
        delete.setOnClickListener(view -> showDeleteDialog());
    }

    private void showDeleteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xóa công thức");
        builder.setMessage("Bạn có chắc chắn muốn xóa công thức này không?");

        builder.setPositiveButton("Xóa", (dialog, which) -> {
            Toast.makeText(this, "Công thức đã bị xóa!", Toast.LENGTH_SHORT).show();
            finish(); // Đóng Activity sau khi xóa
        });

        builder.setNegativeButton("Hủy", (dialog, which) -> dialog.dismiss());

        builder.show();
    }
}