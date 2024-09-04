package com.example.hk1_nam2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_button_navigation_view);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        aFragment = new AFragment();
        bFragment = new BFragment();

        fragmentManager = getSupportFragmentManager(); // Sử dụng getSupportFragmentManager()
        //LoadFragment
        loadFragment(aFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.menuA:
                        loadFragment(aFragment);
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment A", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuB:
                        loadFragment(bFragment);
                        Toast.makeText(ButtonNavigationViewActivity.this, "Fragment B", Toast.LENGTH_SHORT).show();
                        break;
                    // ... other cases
                }
                return true;
            }});
    }

    void loadFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commit();
    }
}