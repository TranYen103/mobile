package com.example.do_an;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        emailLogin = findViewById(R.id.Email_User);
        passwordLogin = findViewById(R.id.Password_User);
        btnLogin = findViewById(R.id.btn_Login);
        btn_Register = findViewById(R.id.btn_Register);
        tvForgotPassword = findViewById(R.id.QuenMatKhau);

        firebase_Auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(v -> LoginUser());
        tvForgotPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });
        btn_Register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
    private void LoginUser(){
        String email = emailLogin.getText().toString().trim();
        String password = passwordLogin.getText().toString().trim();

        boolean hasError = false;
        if (email.isEmpty()) {
            emailLogin.setError("Vui lòng nhập email");
            hasError = true;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLogin.setError("Email không đúng định dạng!");
            hasError = true;
        }
        if (password.isEmpty()) {
            passwordLogin.setError("Vui lòng nhập password");
            hasError = true;
        }
        if (hasError) return;


        firebase_Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, task -> {
           if (task.isSuccessful()){
               Toast.makeText(LoginActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
//               startActivity(new Intent(LoginActivity.this, MainActivity.class));
               finish();
           } else Toast.makeText(LoginActivity.this, "Đăng nhập thất bại: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

}