package com.luongthuan.loginmvvm;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements LoginCallback {

    EditText edtPass, edtEmail;
    Switch swRemember;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginViewModel = new LoginViewModel(this);
        init();
        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        edtEmail.setText(sharedPreferences.getString("email", ""));
        edtPass.setText(sharedPreferences.getString("pass", ""));
        swRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                loginViewModel.login(email, pass);
            }
        });

    }

    private void init() {
        btnLogin = findViewById(R.id.btnLogin);
        edtPass = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);
        swRemember = findViewById(R.id.swRemember);
    }


    @Override
    public void onSuccess() {
        String email = edtEmail.getText().toString().trim();
        String pass = edtPass.getText().toString().trim();
        Toast.makeText(this, "Login Successfull", Toast.LENGTH_LONG).show();
        if (swRemember.isChecked()) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", email);
            editor.putString("pass", pass);
            editor.putBoolean("checked", true);
            editor.commit();
        }
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "Đăng nhập thất bại mật khẩu hoặc email không hợp lệ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setErorEmail() {
        edtEmail.setError("Vui lòng nhập email");
    }

    @Override
    public void setErorPassword() {
        edtPass.setError("Vui lòng nhập password");
    }

    @Override
    public void navigateHome() {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
    }
}