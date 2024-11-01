package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
//Khai bao bien
    EditText edtNhanDL;
    Button btnGoc, btnBP;
    Intent myIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Anh xa toi view
        edtNhanDL = findViewById(R.id.edtNhanDL);
        btnGoc = findViewById(R.id.btnGoc);
        btnBP = findViewById(R.id.btnBP);
        myIntent = getIntent();
        int a = myIntent.getIntExtra("a",0);
        edtNhanDL.setText(a+"");
        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent.putExtra("rtA",a);
                setResult(99,myIntent);
                finish();
            }
        });
        btnBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myIntent.putExtra("rtAA",a*a);
                setResult(100, myIntent);
                finish();
            }
        });
    }
}