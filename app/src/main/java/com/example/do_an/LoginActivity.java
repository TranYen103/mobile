package com.example.do_an;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
private EditText emailLogin, passwordLogin;
private Button btnLogin, btn_Register;
private FirebaseAuth firebase_Auth;
private TextView tvForgotPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        emailLogin = findViewById(R.id.Email_User);
        passwordLogin = findViewById(R.id.Password_User);
        btnLogin = findViewById(R.id.btn_Login);
        btn_Register = findViewById(R.id.btn_Register);

        firebase_Auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(v -> LoginUser());
        btn_Register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
    private void LoginUser(){
        String email = emailLogin.getText().toString().trim();
        String password = passwordLogin.getText().toString().trim();
//        if (email.isEmpty()){
//            Toast.makeText(LoginActivity.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
//        } else if (password.isEmpty())  Toast.makeText(LoginActivity.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập email và mật khẩu!", Toast.LENGTH_SHORT).show();
            return;
        }

        firebase_Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
           if (task.isSuccessful()){
               Toast.makeText(LoginActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
               startActivity(new Intent(LoginActivity.this, MainActivity.class));
               finish();
           } else Toast.makeText(LoginActivity.this, "Đăng nhập thất bại: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
        });


    }
}