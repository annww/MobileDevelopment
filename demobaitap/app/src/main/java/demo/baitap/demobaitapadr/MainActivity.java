package demo.baitap.demobaitapadr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import demo.baitap.demobaitapadr.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button btnbai1, btnbai2, btnbai3, btnbai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnbai1 = findViewById(R.id.btnbai1);
        btnbai2 = findViewById(R.id.btnbai2);
//        btnbai3 = findViewById(R.id.btnbai3);
//        btnbai4 = findViewById(R.id.btnbai4);
//        btnbai4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent4 = new Intent(MainActivity.this, Bai4.class);
//                startActivity(intent4);
//            }
//        });
//        btnbai3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(MainActivity.this, Bai3.class);
//                startActivity(intent3);
//            }
//        });
        /*btnbai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Bai1.class);
                startActivity(intent1);
            }
        });*/
//        btnbai2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent2 = new Intent(MainActivity.this, Bai2.class);
//                startActivity(intent2);
//            }
//        });
//

    }
    public void Bai1View(View v){
        Intent intent1 = new Intent(MainActivity.this, Bai1.class);
        startActivity(intent1);
    }

}
