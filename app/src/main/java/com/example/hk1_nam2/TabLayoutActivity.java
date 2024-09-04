package com.example.hk1_nam2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class TabLayoutActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    ArrayList<Fragment> mangfragments = new ArrayList<>();
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_layout);

//        anh xa
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);

        mangfragments.add(new AFragment());
        mangfragments.add(new BFragment());
        mangfragments.add(new AFragment());


        fragmentManager = getSupportFragmentManager();
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(fragmentManager, getLifecycle(), mangfragments);
        viewPager2.setAdapter(viewPager2Adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1").setIcon(R.drawable.instagram));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2").setIcon(R.drawable.toptop));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3").setIcon(R.drawable.chrome));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}