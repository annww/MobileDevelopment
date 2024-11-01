package vn.duongthianhhong.a64130758_thigiuaky;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemActivity extends AppCompatActivity {

    TextView rssContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        rssContent = findViewById(R.id.rssContent);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String rssLink = intent.getStringExtra("rss_link");

        // Hiển thị nội dung RSS link
        rssContent.setText("RSS Link: " + rssLink);
    }
}
