package th.duongthianhhong.thuchanh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1, edtNumber2;
    private RadioGroup radioGroupOperations;
    private RadioButton rbAdd, rbSubtract, rbMultiply, rbDivide;
    private Button btnCalculate;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        radioGroupOperations = findViewById(R.id.radioGroupOperations);
        rbAdd = findViewById(R.id.rbAdd);
        rbSubtract = findViewById(R.id.rbSubtract);
        rbMultiply = findViewById(R.id.rbMultiply);
        rbDivide = findViewById(R.id.rbDivide);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number1Str = edtNumber1.getText().toString();
                String number2Str = edtNumber2.getText().toString();

                if (number1Str.isEmpty() || number2Str.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ số", Toast.LENGTH_SHORT).show();
                    return;
                }

                double number1 = Double.parseDouble(number1Str);
                double number2 = Double.parseDouble(number2Str);
                double result = 0;
                boolean isOperationSelected = false;

                if (rbAdd.isChecked()) {
                    result = number1 + number2;
                    isOperationSelected = true;
                } else if (rbSubtract.isChecked()) {
                    result = number1 - number2;
                    isOperationSelected = true;
                } else if (rbMultiply.isChecked()) {
                    result = number1 * number2;
                    isOperationSelected = true;
                } else if (rbDivide.isChecked()) {
                    if (number2 == 0) {
                        Toast.makeText(MainActivity.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = number1 / number2;
                    isOperationSelected = true;
                }

                if (isOperationSelected) {
                    txtResult.setText("Kết quả: " + result);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn phép toán", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
