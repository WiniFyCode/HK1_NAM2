package com.example.hk1_nam2;


import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycle_view extends AppCompatActivity {

    RecyclerView rcvChuDe;
    ArrayList<MODEL_CHUDE> chudedata = new ArrayList<>();
    CHUDE_ADAPTER adaptercd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);

        rcvChuDe = findViewById(R.id.rcvChuDeSach);
        chudedata.add(new MODEL_CHUDE("Tai chinh", R.drawable.finance));
        chudedata.add(new MODEL_CHUDE("Ngoai ngu", R.drawable.foreign_language));
        chudedata.add(new MODEL_CHUDE("Mang", R.drawable.internet));
        chudedata.add(new MODEL_CHUDE("Media", R.drawable.media));
        chudedata.add(new MODEL_CHUDE("Luat", R.drawable.rule));chudedata.add(new MODEL_CHUDE("Tai chinh", R.drawable.finance));
        chudedata.add(new MODEL_CHUDE("Ngoai ngu", R.drawable.foreign_language));
        chudedata.add(new MODEL_CHUDE("Mang", R.drawable.internet));
        chudedata.add(new MODEL_CHUDE("Media", R.drawable.media));
        chudedata.add(new MODEL_CHUDE("Luat", R.drawable.rule));chudedata.add(new MODEL_CHUDE("Tai chinh", R.drawable.finance));
        chudedata.add(new MODEL_CHUDE("Ngoai ngu", R.drawable.foreign_language));
        chudedata.add(new MODEL_CHUDE("Mang", R.drawable.internet));
        chudedata.add(new MODEL_CHUDE("Media", R.drawable.media));
        chudedata.add(new MODEL_CHUDE("Luat", R.drawable.rule));chudedata.add(new MODEL_CHUDE("Tai chinh", R.drawable.finance));
        chudedata.add(new MODEL_CHUDE("Ngoai ngu", R.drawable.foreign_language));
        chudedata.add(new MODEL_CHUDE("Mang", R.drawable.internet));
        chudedata.add(new MODEL_CHUDE("Media", R.drawable.media));
        chudedata.add(new MODEL_CHUDE("Luat", R.drawable.rule));
        chudedata.add(new MODEL_CHUDE("Ngoai ngu", R.drawable.foreign_language));
        chudedata.add(new MODEL_CHUDE("Mang", R.drawable.internet));
        chudedata.add(new MODEL_CHUDE("Media", R.drawable.media));
        chudedata.add(new MODEL_CHUDE("Luat", R.drawable.rule));

        adaptercd = new CHUDE_ADAPTER(chudedata, this);
        rcvChuDe.setAdapter(adaptercd);
//        rcvChuDe.setLayoutManager(new GridLayoutManager(this,3));
        rcvChuDe.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
    }
}