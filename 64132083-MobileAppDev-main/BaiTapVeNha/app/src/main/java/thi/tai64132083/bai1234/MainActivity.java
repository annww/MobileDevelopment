package thi.tai64132083.bai1234;

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

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    EditText etdLink;
    Button btnLink;
    TextView txtKQ;
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
        //anh xa toi view
        etdLink = findViewById(R.id.edtLink);
        btnLink = findViewById(R.id.btnLink);
        txtKQ = findViewById(R.id.txtKQ);
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = getApi(etdLink.getText().toString());
                txtKQ.setText(txt);
            }
        });
    }

    private String getApi(String string) {
        try {
            // Sử dụng địa chỉ IP thay vì localhost
            URL url = new URL(string);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + responseCode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }
                sc.close();
                return inline.toString();
            }

        } catch (IOException e) {
            return e.getMessage();
        }

    }
}