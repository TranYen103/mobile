package com.example.do_an;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Share_RepiceActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_share_repice);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Thiết lập Toolbar tùy chỉnh
        Toolbar toolbar = findViewById(R.id.Toolbar_share);

    }

}