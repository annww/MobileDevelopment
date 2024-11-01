package vn.duongthianhhong.a64130758_thigiuaky;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class activityBai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai4);
        Button btnFacebook = findViewById(R.id.btnfb);
        Button btnGithub = findViewById(R.id.btngithub);

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thay "your_facebook_url" bằng URL Facebook của bạn
                String facebookUrl = "https://www.facebook.com/vianunreal";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookUrl));
                startActivity(intent);
            }
        });

        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thay "your_github_url" bằng URL GitHub của bạn
                String githubUrl = "https://github.com/annww";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
                startActivity(intent);
            }
        });
    }
}