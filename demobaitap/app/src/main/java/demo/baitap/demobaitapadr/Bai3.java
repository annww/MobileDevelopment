//package demo.baitap.demobaitapadr;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//
//
//import java.util.ArrayList;
//public class Bai3 extends AppCompatActivity {
//
//    ArrayList<String> list;
//    ArrayAdapter<String> myAdapter;
//    ListView lv;
//    Button btnThem;
//    EditText edtThem;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_bai3);
//        list = new ArrayList<>();
//        list.add("Hỏi Thăm Nhau");
//        list.add("Lá Xa Lìa Cành");
//        list.add("Trách Ai Vô Tình");
//        list.add("Hỏi Vợ Ngoại Thành");
//        list.add("Nắng Ấm Xa Dần");
//        list.add("Lạc Trôi");
//        lv = findViewById(R.id.lv);
//        btnThem = findViewById(R.id.btnThem);
//        edtThem = findViewById(R.id.edtThem);
//        myAdapter = new ArrayAdapter<>(Bai3.this, R.layout.list_item, R.id.textItem,list);
//        lv.setAdapter(myAdapter);
//
//        btnThem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tenBaiHat = edtThem.getText().toString();
//                list.add(tenBaiHat);
//                myAdapter.notifyDataSetChanged();
//            }
//        });
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), list.get(i), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}