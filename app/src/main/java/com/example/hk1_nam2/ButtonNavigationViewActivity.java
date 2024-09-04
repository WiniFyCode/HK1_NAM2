package com.example.hk1_nam2;

//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class ButtonNavigationViewActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    AFragment aFragment;
    BFragment bFragment;

    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_navigation_view);

        fragmentManager = getSupportFragmentManager(); // Sử dụng getSupportFragmentManager()
        bottomNavigationView = findViewById(R.id.bottomNavView);
        aFragment = new AFragment();
        bFragment = new BFragment();

        //Set default fragment
        loadFragment(aFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menuA:
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment A", Toast.LENGTH_SHORT).show();
                        loadFragment(aFragment);
                        break;
                    case R.id.menuB:
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment B", Toast.LENGTH_SHORT).show();
                        loadFragment(bFragment);
                        break;
                    case R.id.menuC:
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment C", Toast.LENGTH_SHORT).show();
                        loadFragment(aFragment);
                        break;
                    case R.id.menuD:
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment D", Toast.LENGTH_SHORT).show();
                        loadFragment(bFragment);
                        break;
                    case R.id.menuE:
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment E", Toast.LENGTH_SHORT).show();
                        loadFragment(aFragment);
                        break;
                }
                return true;
            }
        });
    }

    public void loadFragment(Fragment fragment) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.frameBottomNav, fragment);
//        transaction.commit();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameBottomNav, fragment).commit();
    }
}