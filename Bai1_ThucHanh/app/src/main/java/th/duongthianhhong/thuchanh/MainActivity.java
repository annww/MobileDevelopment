package th.duongthianhhong.thuchanh;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1, edtNumber2;
    private TextView txtResult;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo các đối tượng giao diện
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        // Sự kiện cho nút Cộng
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        // Sự kiện cho nút Trừ
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        // Sự kiện cho nút Nhân
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        // Sự kiện cho nút Chia
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    private void performOperation(char operation) {
        // Lấy giá trị từ các EditText
        String num1Str = edtNumber1.getText().toString();
        String num2Str = edtNumber2.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            try {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;

                // Thực hiện phép toán tương ứng
                switch (operation) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            txtResult.setText("Không thể chia cho 0!");
                            return;
                        }
                        break;
                }

                // Hiển thị kết quả
                txtResult.setText("Kết quả: " + result);
            } catch (NumberFormatException e) {
                txtResult.setText("Vui lòng nhập đúng số.");
            }
        } else {
            txtResult.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }
}
