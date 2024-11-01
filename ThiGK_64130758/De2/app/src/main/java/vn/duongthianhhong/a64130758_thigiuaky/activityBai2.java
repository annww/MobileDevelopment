package vn.duongthianhhong.a64130758_thigiuaky;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class activityBai2 extends AppCompatActivity {

    ListView rssListView;
    String[] rssLinks = {
            "https://vnexpress.net/rss/tin-moi-nhat.rss",
            "https://tuoitre.vn/rss/tin-moi-nhat.rss",
            "https://thanhnien.vn/rss/home.rss",
            "https://nld.com.vn/rss/home.rss"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        rssListView = findViewById(R.id.rssListView);

        // Tạo ArrayAdapter và thiết lập cho ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, rssLinks);
        rssListView.setAdapter(adapter);

        // Bắt sự kiện click cho từng item của ListView
        rssListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedLink = rssLinks[position];

                // Sử dụng Intent để mở liên kết bằng trình duyệt
                Intent intent = new Intent(activityBai2.this, ItemActivity.class);
                intent.putExtra("rss_link", selectedLink);
                startActivity(intent);
            }
        });
    }
}
