package com.example.do_an;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.util.Patterns;

public class RegisterActivity extends AppCompatActivity {
    private EditText edName, edEmail, edPassword, edConfirmPassword;
    private Button btnRegister;
    ImageButton btnBack;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        edName = findViewById(R.id.Name_Register);
        edEmail = findViewById(R.id.Email_Register);
        edPassword = findViewById(R.id.Password_Register);
        edConfirmPassword = findViewById(R.id.Check_Password);
        btnRegister = findViewById(R.id.Register);
        btnBack = findViewById(R.id.Back_Register);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance("https://doanmobile-t13-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("User");

        btnRegister.setOnClickListener(v -> registerUser());
        btnBack.setOnClickListener(v -> finish());
    }
    private void registerUser(){
        String name = edName.getText().toString().trim();
        String email = edEmail.getText().toString().trim();
        String password = edPassword.getText().toString().trim();
        String confirmPassword = edConfirmPassword.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edEmail.setError("Email không đúng định dạng!");
            return;
        }
        if (password.length() < 6){
            Toast.makeText(RegisterActivity.this, "Mật khẩu phải có ít nhất 6 ký tự!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirmPassword)){
            Toast.makeText(RegisterActivity.this, "Mật khẩu xác nhận không khớp! Vui lòng kiểm tra lại.", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, task -> {
            if (task.isSuccessful()){
                String userId = firebaseAuth.getCurrentUser().getUid();
                User newUser = new User(userId, name, email);
                databaseReference.child(userId).setValue(newUser).addOnCompleteListener(task1 -> {
                   if (task1.isSuccessful()){
                       Toast.makeText(RegisterActivity.this, "Đăng ký thành công.", Toast.LENGTH_SHORT).show();
                       finish();
                   } else Toast.makeText(RegisterActivity.this, "Lỗi khi lưu dữ liệu: " + task1.getException().getMessage(), Toast.LENGTH_SHORT).show();
                });
            } else Toast.makeText(RegisterActivity.this, "Đăng ký thất bại: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
        });
    }
}
