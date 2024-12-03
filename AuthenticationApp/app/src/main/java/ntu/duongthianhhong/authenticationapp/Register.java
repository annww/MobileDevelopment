package ntu.duongthianhhong.authenticationapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextInputEditText inputEmailSignUp, inputPassSignUp, inputUserSignUp, inputConfirmPassSignUp;
    TextInputLayout inputEmailLayoutSignUp, inputPassLayoutSignUp, inputUserLayoutSignUp, inputConfirmPassLayoutSignUp;
    TextView ivalidPass, ivalidMail, ivalidUser, textClickSignIn;
    Button btnSignUp;
    String email, password, userName;

    private void getControl(){
        inputEmailSignUp = findViewById(R.id.inputEmailSignUp);
        inputPassSignUp = findViewById(R.id.inputPassSignUp);
        inputUserSignUp = findViewById(R.id.inputUserSignUp);
        inputConfirmPassSignUp = findViewById((R.id.inputConfirmPassSignUp));
        inputEmailLayoutSignUp = findViewById(R.id.inputEmailLayoutSignUp);
        inputPassLayoutSignUp = findViewById(R.id.inputPassLayoutSignUp);
        inputUserLayoutSignUp = findViewById(R.id.inputUserLayoutSignUp);
        inputConfirmPassLayoutSignUp = findViewById((R.id.inputConfirmPassLayoutSignUp));
        btnSignUp = findViewById(R.id.btnSignUp);
        ivalidMail = findViewById(R.id.ivalidMail);
        ivalidPass = findViewById(R.id.ivalidPass);
        ivalidUser = findViewById(R.id.ivalidUser);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        getControl();

        // Thêm TextWatcher cho email và mật khẩu
        inputEmailSignUp.addTextChangedListener(checkEmail);
        inputPassSignUp.addTextChangedListener(checkPass);
        inputUserSignUp.addTextChangedListener(checkUser);

        // Xử lý khi người dùng nhấn nút Đăng ký
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ các trường nhập liệu
                email = inputEmailSignUp.getText().toString().trim();
                password = inputPassSignUp.getText().toString().trim();
                userName = inputUserSignUp.getText().toString().trim();
                String confirmPassword = inputConfirmPassSignUp.getText().toString().trim();

                // Kiểm tra các thông tin nhập vào
                if (TextUtils.isEmpty(email)) {
                    ivalidMail.setText("Vui lòng nhập email!");
                    return;
                }
                if (!isValidEmail(email)) {
                    ivalidMail.setText("Email chưa hợp lệ!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    ivalidPass.setText("Vui lòng nhập mật khẩu!");
                    return;
                }
                if (!isValidPassword(password)) {
                    ivalidPass.setText("Mật khẩu phải từ 8 ký tự, bao gồm chữ hoa, chữ thường, số và ký tự đặc biệt!");
                    return;
                }
                if (TextUtils.isEmpty(userName)) {
                    ivalidUser.setText("Vui lòng nhập tên tài khoản!");
                    return;
                }
                if (!isValidUserName(userName)) {
                    ivalidUser.setText("Tên tài khoản không hợp lệ!");
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    ivalidPass.setText("Mật khẩu xác nhận không khớp!");
                    return;
                }

                // Đăng ký tài khoản với Firebase
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Đăng ký thành công
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    // Cập nhật thông tin người dùng (ví dụ như tên người dùng) nếu cần
                                    user.updateProfile(new UserProfileChangeRequest.Builder()
                                                    .setDisplayName(userName)
                                                    .build())
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        // Chuyển sang màn hình chính hoặc màn hình đăng nhập
                                                        Intent intent = new Intent(Register.this, MainActivity.class);
                                                        startActivity(intent);
                                                        finish();
                                                    } else {
                                                        ivalidUser.setText("Có lỗi khi cập nhật tên người dùng!");
                                                    }
                                                }
                                            });
                                } else {
                                    // Đăng ký thất bại, hiển thị thông báo lỗi
                                    ivalidMail.setText("Có lỗi khi đăng ký: " + task.getException().getMessage());
                                }
                            }
                        });
            }
        });

        // Nếu người dùng đã có tài khoản, chuyển tới màn hình đăng nhập
        textClickSignIn.setOnClickListener(changeSignInActivity);
    }

}