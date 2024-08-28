package com.example.hk1_nam2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CHUDE_ADAPTER extends RecyclerView.Adapter<CHU_VIEWHOLDER> {
    Context context;
    ArrayList<MODEL_CHUDE> data;

    public CHUDE_ADAPTER(ArrayList<MODEL_CHUDE> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public CHU_VIEWHOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chudesach_layout, null);
        return new CHU_VIEWHOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CHU_VIEWHOLDER holder, int position) {
        MODEL_CHUDE cd = data.get(position);
        holder.imgHinhChuDe.setImageResource(cd.HinhChuDe);
        holder.tvTenChuDe.setText(cd.TenChuDe);
    }

    @Override
    public int getItemCount() {
        return data.size();
//        return Math.min(data.size(),5);
    }
}

class CHU_VIEWHOLDER extends RecyclerView.ViewHolder {

    ImageView imgHinhChuDe;
    TextView tvTenChuDe;

    public CHU_VIEWHOLDER(@NonNull View itemView) {
        super(itemView);

//        Anh xe - itemView chinh la  chudesach_layout
        imgHinhChuDe = itemView.findViewById(R.id.imgHinhChuDe);
        tvTenChuDe = itemView.findViewById(R.id.tvTenChuDe);

    }
}
