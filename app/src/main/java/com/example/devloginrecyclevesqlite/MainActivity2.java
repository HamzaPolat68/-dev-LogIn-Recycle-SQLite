package com.example.devloginrecyclevesqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView benimrecyc;
    private ArrayList<Image> images;
    private MyrecycAdaptor myadaptor;
    @SuppressLint({"NotifyDataSetChanged", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        benimrecyc=findViewById(R.id.myrecyc);
        images=new ArrayList<>();
        myadaptor=new MyrecycAdaptor(images);
        benimrecyc.setAdapter(myadaptor);
        benimrecyc.setLayoutManager(new LinearLayoutManager(this));
        diziolustur();
        myadaptor.notifyDataSetChanged();
    }

    private void diziolustur() {
        images.add(new Image(R.drawable.resim1));
        images.add(new Image(R.drawable.resim3));
        images.add(new Image(R.drawable.resim5));
        images.add(new Image(R.drawable.resim7));
        images.add(new Image(R.drawable.resim9));
        images.add(new Image(R.drawable.resim2));
        images.add(new Image(R.drawable.resim4));
        images.add(new Image(R.drawable.resim6));
        images.add(new Image(R.drawable.resim8));
        images.add(new Image(R.drawable.resim10));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent geriIntent=new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriIntent);
    }

}
