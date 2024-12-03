package th.duongthianhhong.chuyenmanhinh_fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button englishButton = findViewById(R.id.buttonEnglish);
        Button mathButton = findViewById(R.id.buttonMath);
        Button programmingButton = findViewById(R.id.buttonProgramming);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnglishActivity.class);
                startActivity(intent);
            }
        });

        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MathActivity.class);
                startActivity(intent);
            }
        });

        programmingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgrammingActivity.class);
                startActivity(intent);
            }
        });
    }
}