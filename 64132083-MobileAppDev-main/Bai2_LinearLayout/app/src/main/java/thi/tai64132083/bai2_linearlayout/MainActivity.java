package thi.tai64132083.bai2_linearlayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnCong, btnTru, btnNhan, btnChia;
    int a = 0;
    int b = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //anh xa id
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(edtA.getText().toString());
                b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText((a+b)+"");
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(edtA.getText().toString());
                b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText((a-b)+"");
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(edtA.getText().toString());
                b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText((a*b)+"");
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a = Integer.parseInt(edtA.getText().toString());
                b = Integer.parseInt(edtB.getText().toString());
                edtKQ.setText(((float)a/b)+"");
            }
        });

    }

}