package com.example.devloginrecyclevesqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyrecycAdaptor extends RecyclerView.Adapter<MyrecycAdaptor.Myholder> {
    private ArrayList<Image> images;

    public MyrecycAdaptor(ArrayList<Image> images) {
        this.images=images;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);

        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.resim.setImageResource(images.get(position).getResim());

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        ImageView resim;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            resim=itemView.findViewById(R.id.resimler);
        }
    }
}
