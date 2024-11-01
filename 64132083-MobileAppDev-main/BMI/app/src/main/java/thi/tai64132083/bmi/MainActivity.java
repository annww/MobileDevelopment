package thi.tai64132083.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity {
    TextView txtKQ;
    EditText edtCanNang, edtChieuCao;
    Button btnBMI;

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
        edtCanNang = findViewById(R.id.edtCanNang);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        txtKQ = findViewById(R.id.txtKQ);
        btnBMI = findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float chieuCao = Float.parseFloat(edtChieuCao.getText().toString());
                    float canNang = Float.parseFloat(edtCanNang.getText().toString());
                    if(!(1.0f < chieuCao && chieuCao < 2.2f)){
                        txtKQ.setText("Chiều cao không hợp lý!!! Mời nhập lại....");
                        edtChieuCao.setText("");
                    } else if (!(2f < canNang && canNang < 200f)) {
                        txtKQ.setText("Cân nặng không hợp lý !!! vui lòng nhập lại...");
                    }else{
                        float bMI = canNang / (chieuCao * chieuCao);
                        if (bMI < 18.5f) {
                            txtKQ.setText("Gầy");
                        } else if (bMI >= 18.5f && bMI < 24.9f) {
                            txtKQ.setText("Bình thường");
                        } else if (bMI >= 24.9f && bMI <= 29.9f) {
                            txtKQ.setText("Thừa cân");
                        } else {
                            txtKQ.setText("Béo phì");
                        }
                    }

                } catch (InputMismatchException e) {
                    txtKQ.setText("Vui lòng nhập một số hợp lệ.");

                }
            }
        });
    }
}