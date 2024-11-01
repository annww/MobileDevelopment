package thi.an.thigk;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<QuocGia> qgs;

    void getControl(){
        recyclerView = findViewById(R.id.recycleView);
        qgs = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);
        getControl();
        add();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(qgs));
    }

    void add(){
        qgs.add(new QuocGia("Bồ Đào Nha", "2000000", R.drawable.bo_dao_nha));
        qgs.add(new QuocGia("Pháp", "12000000", R.drawable.phap));
        qgs.add(new QuocGia("Hàn Quốc", "200000", R.drawable.han_quoc));
    }
    public void viewTrangChu(View v){
        finish();
    }
}