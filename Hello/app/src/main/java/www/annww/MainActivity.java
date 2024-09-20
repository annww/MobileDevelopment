package www.annww;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import www.annww.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    public void SayHello(View v){
        // Tim dieu khien
        EditText soThuNhat = findViewById(R.id.editTextNumber);
        EditText soThuHai = findViewById(R.id.editTextNumber2);
        // Lay du lieu
        String s1 = soThuNhat.getText().toString();
        String s2= soThuHai.getText().toString();
        // Chuyen kieu
        int num1 = Integer.parseInt(s1);
        double num2 = Double.parseDouble(s2);

        // Tinh toan
        double tong = num1 + num2;

        // Chuan bi xuat
        String chuoiXuat = "Tong la: " + String.valueOf(tong);
        Toast.makeText(this, "You touched me", Toast.LENGTH_LONG).show();
    }

}