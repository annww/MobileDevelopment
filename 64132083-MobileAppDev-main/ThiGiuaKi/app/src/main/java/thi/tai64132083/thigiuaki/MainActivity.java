package thi.tai64132083.thigiuaki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import thi.tai64132083.thigiuaki.Bai1;
import thi.tai64132083.thigiuaki.Bai2;
import thi.tai64132083.thigiuaki.Bai3;
import thi.tai64132083.thigiuaki.Bai4;

public class MainActivity extends AppCompatActivity {
    Button btnBai2, btnBai1, btnBai3, btnBai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnBai2 = findViewById(R.id.btn_bai2);
        btnBai1 = findViewById(R.id.btn_bai1);
        btnBai3 = findViewById(R.id.btn_bai3);
        btnBai4 = findViewById(R.id.btn_bai4);
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this, Bai4.class);
                startActivity(intent4);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Bai3.class);
                startActivity(intent3);
            }
        });
        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Bai1.class);
                startActivity(intent1);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Bai2.class);
                startActivity(intent2);
            }
        });

    }
}