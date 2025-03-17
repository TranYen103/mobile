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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_an.adapter.SearchAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
SearchView searchView;
RecyclerView recyclerView;
ArrayList<SearchItem> arrayList = new ArrayList<>();
ArrayList<SearchItem> searchList=new ArrayList<>();
String[] foodList=new String[]{"Gà chiên mắm","Heo chiên giòn","Bò xào tỏi","Canh bí đỏ","Tôm hấp","Nui xào giòn",
        "Gà chiên mắm","Heo chiên giòn","Bò xào tỏi","Canh bí đỏ","Tôm hấp","Nui xào giòn"};
//String[] foodTime=new String[]{"20ph", "15ph", "10ph","25ph","5ph","12ph"};
int[]imgList=new int[]{R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks,
        R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks,
        R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks,
        R.drawable.catergory_drinks,R.drawable.catergory_drinks,R.drawable.catergory_drinks};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addControl();
        handleEvents();
    }

    private void handleEvents() {
        for (int i =0; i< foodList.length;i++){
            SearchItem searchItem = new SearchItem();
            searchItem.setFoodName(foodList[i]);
            searchItem.setImg(imgList[i]);
            arrayList.add(searchItem);
        }
RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchActivity.this);
recyclerView.setLayoutManager(layoutManager);

SearchAdapter searchAdapter=new SearchAdapter(SearchActivity.this,arrayList);
recyclerView.setAdapter(searchAdapter);
searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
    @Override
    public boolean onQueryTextSubmit(String query) {
        searchList=new ArrayList<>();
        if(query.length()>0){
            for (int i =0; i<arrayList.size();i++){
                if(arrayList.get(i).getFoodName().toUpperCase().contains(query.toUpperCase())){
                    SearchItem searchItem =new SearchItem();
                    searchItem.setFoodName(arrayList.get(i).getFoodName());
                    searchItem.setImg(arrayList.get(i).getImg());
                    searchList.add(searchItem);
                }
            }
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchActivity.this);
            recyclerView.setLayoutManager(layoutManager);

            SearchAdapter searchAdapter=new SearchAdapter(SearchActivity.this,searchList);
            recyclerView.setAdapter(searchAdapter);
        }
        else{            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchActivity.this);
            recyclerView.setLayoutManager(layoutManager);

            SearchAdapter searchAdapter=new SearchAdapter(SearchActivity.this,arrayList);
            recyclerView.setAdapter(searchAdapter);}
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchList=new ArrayList<>();
        if(newText.length()>0){
            for (int i =0; i<arrayList.size();i++){
                if(arrayList.get(i).getFoodName().toUpperCase().contains(newText.toUpperCase())){
                    SearchItem searchItem =new SearchItem();
                    searchItem.setFoodName(arrayList.get(i).getFoodName());
                    searchItem.setImg(arrayList.get(i).getImg());
                    searchList.add(searchItem);
                }
            }
            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchActivity.this);
            recyclerView.setLayoutManager(layoutManager);

            SearchAdapter searchAdapter=new SearchAdapter(SearchActivity.this,searchList);
            recyclerView.setAdapter(searchAdapter);
        }
        else{            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchActivity.this);
            recyclerView.setLayoutManager(layoutManager);

            SearchAdapter searchAdapter=new SearchAdapter(SearchActivity.this,arrayList);
            recyclerView.setAdapter(searchAdapter);}
        return false;
    }
});
    }

    private void addControl() {
    recyclerView=findViewById(R.id.recyclerView);
    searchView=findViewById(R.id.searchView);
    searchView.setIconified(false);
    searchView.clearFocus();

    }
}