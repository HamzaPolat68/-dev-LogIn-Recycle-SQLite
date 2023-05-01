package com.example.devloginrecyclevesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    RelativeLayout r1;
    Button btn,butonekle;
    EditText kAdi,ksifre;
    TextView showtxt;
    SQLiteDatabase db;
    String KulAdi,Kulsifre,DogruKadi="Hamza Polat",DogruSifre="1907";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1=findViewById(R.id.img1);
        r1=findViewById(R.id.pano);
        btn=findViewById(R.id.btngir);
        butonekle=findViewById(R.id.btnekle);
        kAdi=findViewById(R.id.editTextPersonName);
        ksifre=findViewById(R.id.editTextPassword);
        showtxt=findViewById(R.id.showtxt);
        try {
            db=this.openOrCreateDatabase("Login",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS person (Id INTEGER PRIMARY KEY, kulad VARCAHAR, sifre INT)");
        }catch (Exception e){
            e.printStackTrace();
        }
        showtxt.setText("");
        Cursor c=db.rawQuery("SELECT * FROM person",null);
        int IdIndex=c.getColumnIndex("Id");
        int kuladIndex=c.getColumnIndex("kulad");
        int sifreIndex=c.getColumnIndex("sifre");
        while(c.moveToNext()){
            showtxt.append("Id: "+c.getInt(IdIndex)+" KullanıcıAdı:"+c.getInt(kuladIndex)+" Sifre:"+c.getInt(sifreIndex)+"\n");
        }
        Animation anim1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        Animation anim2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.panelanim);
        img1.startAnimation(anim1);
        r1.startAnimation(anim2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KulAdi=kAdi.getText().toString();
                Kulsifre=ksifre.getText().toString();
                if(!TextUtils.isEmpty(KulAdi)&&!TextUtils.isEmpty(Kulsifre)){
                    if(KulAdi.equals(DogruKadi)&& Kulsifre.equals(DogruSifre)){
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        finish();
                        startActivity(intent);
                    }else
                        Toast.makeText(MainActivity.this,"Kullanıcı adı veya şifreyi yanlış girdinniz",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this,"Kullanıcı adı ve şifre boş olamaz ",Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void sqlprog(View view) {
        switch (view.getId()){
            case R.id.btnekle:
                try {
                    db.execSQL("INSERT INTO person(kulad,sifre) VALUES('"+kAdi.getText().toString()+"','"+ksifre.getText().toString()+"')");
                    Toast.makeText(this,"Veri Eklendi",Toast.LENGTH_SHORT).show();
                    kAdi.setText("");
                    ksifre.setText("");
                    getData();
                }catch(Exception e) {

                }break;
        }
    }

    private void getData() {
        showtxt.setText("");
        Cursor c=db.rawQuery("SELECT * FROM person",null);
        int IdIndex=c.getColumnIndex("Id");
        int kuladIndex=c.getColumnIndex("kulad");
        int sifreIndex=c.getColumnIndex("sifre");
        while(c.moveToNext()){
            showtxt.append("Id: "+c.getInt(IdIndex)+" KullanıcıAdı:"+c.getInt(kuladIndex)+" Sifre:"+c.getInt(sifreIndex)+"\n");
        }
        c.close();
    }
}