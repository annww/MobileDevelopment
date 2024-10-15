package com.example.listview_64130758;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Nguon du lieu
    ArrayList<String> dsBaiTho;
    Button btnThem;
    EditText editTextTenBT;
    //
    ListView lvBaiTho;
    void getControl(){
        lvBaiTho=findViewById(R.id.lvBT);
        btnThem = findViewById(R.id.btnThem);
        editTextTenBT = findViewById(R.id.editTenBT);
    }

    //Ham doc du lieu tu nguon bat ky
    ArrayList<String> getData(){
        ArrayList<String> listTenBaiTho = new ArrayList<String>();
        listTenBaiTho.add("Song");
        listTenBaiTho.add("Banh troi nuoc");
        listTenBaiTho.add("Tay Tien");
        listTenBaiTho.add("Dat nuoc");
        listTenBaiTho.add("Tu hat");
        listTenBaiTho.add("Nam quoc son ha");
        return listTenBaiTho;
    }

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
        getControl();
        dsBaiTho =  getData();
        ArrayAdapter<String> adapterBaiTho;
        adapterBaiTho = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsBaiTho);
        lvBaiTho.setAdapter(adapterBaiTho);
        lvBaiTho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XuLyKhiNhanVaoViTri(position);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lay tenn bai
                String tenBai = editTextTenBT.getText().toString();
                // Them vao nguon
                dsBaiTho.add(tenBai);
                //Bao adapter update listview
                adapterBaiTho.notifyDataSetChanged();
            }
        });
    }
    void XuLyKhiNhanVaoViTri(int pos){
        String Item = dsBaiTho.get(pos);
        Toast.makeText(getApplicationContext(),Item,Toast.LENGTH_SHORT).show();
    }
}




