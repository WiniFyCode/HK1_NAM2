package com.example.hk1_nam2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImplicitIntent extends AppCompatActivity {

    AppCompatButton btnPhoto, btnMap, btnMess, btnContact, btnCall;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_implicit_intent);

        //Anh xa
        btnCall = findViewById(R.id.btnCall);
        btnMap = findViewById(R.id.btnMap);
        btnMess = findViewById(R.id.btnMess);
        btnContact = findViewById(R.id.btnContact);
        btnPhoto = findViewById(R.id.btnPhoto);

        // Mo ung dung
        btnMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
                Uri.parse("sms:0368640276");
                startActivity(intent);

            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_GALLERY);
                startActivity(intent);

            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CONTACTS);
                startActivity(intent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/V%C5%A9+Ho%C3%A0,+%C4%90%E1%BB%A9c+Linh,+B%C3%ACnh+Thu%E1%BA%ADn,+Vi%E1%BB%87t+Nam/@11.1499544,107.5780437,21z/data=!4m6!3m5!1s0x31744187fa9e1a47:0x8db12167797e1c8a!8m2!3d11.1469159!4d107.5801033!16s%2Fg%2F1hf_w51p4?entry=ttu"));
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0368640276"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(ImplicitIntent.this, "Không tìm thấy ứng dụng để thực hiện cuộc gọi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
