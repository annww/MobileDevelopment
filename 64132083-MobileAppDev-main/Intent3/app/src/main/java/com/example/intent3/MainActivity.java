package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//Khai bao bien
    EditText edtData, edtKQ;
    Button btnYC;
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
        //Anh xa toi view
        edtData = findViewById(R.id.edtData);
        edtKQ = findViewById(R.id.edtKQ);
        btnYC = findViewById(R.id.btnYC);

        btnYC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtData.getText().toString());
                // Khai bao intent
                Intent myIntent = new Intent(MainActivity.this,ResultActivity.class);
                myIntent.putExtra("a",a);
                startActivityForResult(myIntent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode==99){
            int a = data.getIntExtra("rtA",0);
            edtKQ.setText("Kết quả gốc = "+a);
        }
        if(requestCode==1 && resultCode==100){
            int a = data.getIntExtra("rtAA",0);
            edtKQ.setText("Kết quả bình phương = "+ a);
        }
    }
}