package com.example.hk1_nam2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends AppCompatActivity {
    AFragment aFragment;
    BFragment bFragment;
    AppCompatButton btnFA, btnFB;
    FragmentManager FmManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragment);

        aFragment = new AFragment();
        bFragment = new BFragment();
        btnFA = findViewById(R.id.btnFragmentA);
        btnFB = findViewById(R.id.btnFragmentB);
        FmManager = getSupportFragmentManager();

        btnFA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = FmManager.beginTransaction();
                transaction.replace(R.id.frameLayout, aFragment);
                transaction.commit();
            }
        });

        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = FmManager.beginTransaction();
                transaction.replace(R.id.frameLayout, bFragment);
                transaction.commit();
            }
        });
    }
}