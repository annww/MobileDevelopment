package vn.duongthianhhong.a64130758_thigiuaky;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class activityBai1 extends AppCompatActivity {
    TextView txtKQ;
    EditText edtCanNang, edtChieuCao;
    Button btnBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai1);

        edtCanNang = findViewById(R.id.edtCanNang);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        txtKQ = findViewById(R.id.txtKQ);
        btnBMI = findViewById(R.id.btnBMI);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String canNangStr = edtCanNang.getText().toString();
                String chieuCaoStr = edtChieuCao.getText().toString();

                // Kiểm tra xem các trường có trống hay không
                if (canNangStr.isEmpty() || chieuCaoStr.isEmpty()) {
                    txtKQ.setText("Vui lòng nhập đầy đủ thông tin cân nặng và chiều cao.");
                    return; // Dừng lại ở đây nếu chưa có thông tin
                }

                try {
                    float chieuCao = Float.parseFloat(chieuCaoStr);
                    float canNang = Float.parseFloat(canNangStr);

                    if (!(1.0f < chieuCao && chieuCao < 2.2f)) {
                        txtKQ.setText("Chiều cao không hợp lý!!! Mời nhập lại....");
                        edtChieuCao.setText("");
                    } else if (!(2f < canNang && canNang < 200f)) {
                        txtKQ.setText("Cân nặng không hợp lý !!! vui lòng nhập lại...");
                    } else {
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

                } catch (NumberFormatException e) {
                    txtKQ.setText("Vui lòng nhập một số hợp lệ.");
                }
            }
        });
    }
}
