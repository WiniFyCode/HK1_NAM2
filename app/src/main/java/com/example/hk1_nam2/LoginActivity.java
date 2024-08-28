package com.example.hk1_nam2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    AppCompatButton btnLogin, btnRegisternow;
    AppCompatCheckBox cbRemember;
    SharedPreferences luuThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_activity);


        // Anh xa
        edtPassword = findViewById(R.id.edtPassword);
        edtUsername = findViewById(R.id.edtUsername);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegisternow = findViewById(R.id.btnRegisternow);
        cbRemember = findViewById(R.id.cbRemember);
        luuThongTin = getSharedPreferences("fileSave", Activity.MODE_PRIVATE);// fileSave la ten file de luu thong tin

        // Nap thong tin lan dau
        if (luuThongTin.getBoolean("remember", false)) {
            edtUsername.setText(luuThongTin.getString("username", ""));
            edtPassword.setText(luuThongTin.getString("password", ""));
            cbRemember.setChecked(true);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().toString().equals("admin") && edtPassword.getText().toString().equals("admin")) { // Dòng này đăng nhập với tài khoản và mật khẩu có sẵn

                    // Đăng nhập thành công
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    SharedPreferences.Editor edit = luuThongTin.edit();
                    // Luu thong tin dang nhap neu check box dc chon
                    if (cbRemember.isChecked()) {
                        // Luu thong tin
//                        edit.putString("username", "admin");// Cach cua thay
//                        edit.putString("password", "admin");
//                        edit.putBoolean("remember", true);
                        edit.putString("username", edtUsername.getText().toString()); // Cach ch dc day
                        edit.putString("password", edtPassword.getText().toString());
                        edit.putBoolean("remember", true);
                    } else {
                        // Xoa thong tin
//                        edit.putString("username", "");// Cach cua thay
//                        edit.putString("password", "");
//                        edit.putBoolean("remember", false);
                        edit.clear();
                    }
                    edit.commit();
                } else {
                    Toast.makeText(LoginActivity.this, "Tài khoản chưa được đăng ký", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
