package com.example.do_an;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
SearchView searchView;
RecyclerView recyclerView;
ArrayList<SearchItem> arrayList = new ArrayList<>();
String[] foodList=new String[]{"Gà chiên mắm","Heo chiên giòn","Bò xào tỏi","Canh bí đỏ","Tôm hấp","Nui xào giòn"};
String[] foodTime=new String[]{"20ph", "15ph", "10ph","25ph","5ph","12ph"};
int[]imgList=new int[]{R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks,
        R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        handleEvents();
    }

    private void handleEvents() {

    }

    private void addControl() {
    recyclerView=findViewById(R.id.recyclerView);
    searchView=findViewById(R.id.searchView);

    }
}