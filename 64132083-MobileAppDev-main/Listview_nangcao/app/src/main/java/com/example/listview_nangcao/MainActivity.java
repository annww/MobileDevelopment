package com.example.listview_nangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//khai bao bien
    int listImage[] = {R.drawable.phone1,R.drawable.phone2,R.drawable.phone3,
        R.drawable.phone4, R.drawable.phone5, R.drawable.phone6};
    String listName[]={"Điện thoại Iphone7", "Điện thoại SamSung Galazy S7",
        "Điện thoại Nokia Lumia730", "Điện thoại Sony Xperia XZ",
        "Điện thoaại HTC One E9", "Điện Thoại Vinfast"};
    ArrayList<Phone> listPhone;
    ListView lv;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //anh xa id
        lv = findViewById(R.id.lv);
        //gop 2 mang vao array list
        listPhone = new ArrayList<>();
        for(int i = 0; i<listName.length; i++){
            listPhone.add(new Phone(listImage[i],listName[i]));
        }
        //khai bao adapter
        myAdapter = new MyAdapter(MainActivity.this, R.layout.idlayout, listPhone);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, SubActivity.class);
                myIntent.putExtra("name",listPhone.get(i).getName());
                myIntent.putExtra("image",listPhone.get(i).getImage());
                startActivity(myIntent);
            }
        });
    }
}