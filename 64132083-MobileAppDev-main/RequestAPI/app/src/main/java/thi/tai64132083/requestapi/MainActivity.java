package thi.tai64132083.requestapi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import thi.tai64132083.requestapi.api.ApiService;
import thi.tai64132083.requestapi.model.Employee;
import thi.tai64132083.requestapi.model.Knowledge;

public class MainActivity extends AppCompatActivity {

    TextView tvFact,tvLenght;
    Button btnCallAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       tvFact = findViewById(R.id.tv_fact);
       tvLenght = findViewById(R.id.tv_lenght);
       btnCallAPI = findViewById(R.id.btn_callapi);
       btnCallAPI.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              getAPI();
           }
       });

    }

    private void getAPI() {
        ApiService.apiService.getKnowledgee()
                .enqueue(new Callback<Knowledge>() {
                    @Override
                    public void onResponse(Call<Knowledge> call, Response<Knowledge> response) {
                        if(response.isSuccessful() && response.body()!=null){
                            Knowledge knowledge = response.body();
                            tvFact.setText(knowledge.getFact() );
                            tvLenght.setText(String.valueOf(knowledge.getLength()) );
                        } else {
                            Log.e("API_ERROR", "Không có dữ liệu hoặc phản hồi không thành công");
                        }
                    }

                    @Override
                    public void onFailure(Call<Knowledge> call, Throwable t) {
                        Log.e("API_ERROR", "Gọi API thất bại: " + t.getMessage());
                    }
                });
    }
}
