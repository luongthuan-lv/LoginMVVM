package com.luongthuan.loginmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.luongthuan.loginmvvm.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements LoginCallback {

    EditText edtPass, edtEmail;
    Button btnResgister;
    Switch swRemember;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        ActivityMainBinding activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.setView(ViewModelProviders.of(this,new LoginViewModelFactory(this)).get(LoginViewModel.class));
        init();
        sharedPreferences = getSharedPreferences("dataUser", MODE_PRIVATE);
        edtEmail.setText(sharedPreferences.getString("email",""));
        edtPass.setText(sharedPreferences.getString("pass",""));
        swRemember.setChecked(sharedPreferences.getBoolean("checked",false));
    }

    private void init() {

        edtPass = findViewById(R.id.edtPass);
        edtEmail = findViewById(R.id.edtEmail);
        btnResgister = findViewById(R.id.btnResgister);
        swRemember = findViewById(R.id.swRemember);
    }


    @Override
    public void onSuccess(String notification) {
        String email=edtEmail.getText().toString().trim();
        String pass=edtPass.getText().toString().trim();
        Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
        if (swRemember.isChecked()){
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("email",email);
            editor.putString("pass",pass);
            editor.putBoolean("checked",true);
            editor.commit();
        }
    }

    @Override
    public void onFailure(String notification) {
        Toast.makeText(this,"Đăng nhập thất bại mật khẩu không hợ lệ",Toast.LENGTH_LONG).show();
    }


}