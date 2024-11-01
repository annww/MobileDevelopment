package vn.duongthianhhong.a64130758_thigiuaky;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class activityBai3 extends AppCompatActivity {

    private ArrayList<String> lstTenBaiTho;
    private ArrayAdapter<String> adapter;
    private ListView lvBT;
    private EditText edtTenBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        // Khởi tạo danh sách bài thơ với các bài thơ có sẵn
        lstTenBaiTho = new ArrayList<>();
        lstTenBaiTho.add("Tây Tiến");
        lstTenBaiTho.add("Đất Nước");
        lstTenBaiTho.add("Bánh Trôi Nước");
        lstTenBaiTho.add("Sông");
        lstTenBaiTho.add("Mặt Trời Đứng Yên");
        lstTenBaiTho.add("Cảnh Khuya");
        lstTenBaiTho.add("Chợ Tết");
        lstTenBaiTho.add("Nỗi Nhớ");
        lstTenBaiTho.add("Đường Đi Tây Bắc");
        lstTenBaiTho.add("Chiều Tối");
        lstTenBaiTho.add("Khi Tôi Đứng Đợi");
        lstTenBaiTho.add("Về Miền Trung");
        lstTenBaiTho.add("Hồ Trên Núi");
        lstTenBaiTho.add("Bên Kia Sông Đuống");

        // Khởi tạo ListView và EditText
        lvBT = findViewById(R.id.lvBT);
        edtTenBT = findViewById(R.id.edtTenBT);
        Button btnThem = findViewById(R.id.btnThem);

        // Cài đặt ArrayAdapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lstTenBaiTho);
        lvBT.setAdapter(adapter);

        // Thêm bài thơ mới vào danh sách khi nhấn nút "Thêm"
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPoem = edtTenBT.getText().toString();
                if (!newPoem.isEmpty()) {
                    lstTenBaiTho.add(newPoem);
                    adapter.notifyDataSetChanged(); // Cập nhật ListView
                    edtTenBT.setText(""); // Xóa nội dung EditText
                }
            }
        });
    }
}
