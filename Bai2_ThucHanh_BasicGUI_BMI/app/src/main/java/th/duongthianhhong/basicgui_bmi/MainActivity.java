package th.duongthianhhong.basicgui_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etHeight, etWeight; // Changed to TextInputEditText to match XML
    private RadioGroup radioGroup;
    private RadioButton radioAsian, radioNonAsian;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.txtHeight);
        etWeight = findViewById(R.id.txtWeight);
        radioGroup = findViewById(R.id.radioGroup);
        radioAsian = findViewById(R.id.radioAsian);
        radioNonAsian = findViewById(R.id.radioNonAsian);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightText = etHeight.getText().toString();
        String weightText = etWeight.getText().toString();

        if (heightText.isEmpty() || weightText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đủ chiều cao và cân nặng!", Toast.LENGTH_SHORT).show();
            return;
        }


        double height, weight;
        try {
            height = Double.parseDouble(heightText);
            weight = Double.parseDouble(weightText);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập chiều cao và cân nặng hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (height <= 0 || weight <= 0) {
            Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
            return;
        }

        double heightInMeters = height / 100;
        double bmi = weight / (heightInMeters * heightInMeters);
        boolean isAsian = radioAsian.isChecked();
        String bmiCategory = getBMICategory(bmi, isAsian);
        tvResult.setText("BMI: " + String.format("%.2f", bmi) + "\n" + bmiCategory);
    }

    private String getBMICategory(double bmi, boolean isAsian) {
        String category;

        if (isAsian) {
            if (bmi < 17.5) {
                category = "Thiếu cân";
            } else if (bmi >= 17.5 && bmi <= 22.99) {
                category = "Bình thường";
            } else if (bmi >= 23 && bmi <= 27.99) {
                category = "Thừa cân";
            } else {
                category = "Béo phì";
            }
        } else {
            if (bmi < 18.5) {
                category = "Thiếu cân";
            } else if (bmi >= 18.5 && bmi <= 24.99) {
                category = "Bình thường";
            } else if (bmi >= 25 && bmi <= 29.99) {
                category = "Thừa cân";
            } else {
                category = "Béo phì";
            }
        }
        return category;
    }
}
