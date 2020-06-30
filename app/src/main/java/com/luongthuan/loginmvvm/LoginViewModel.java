package com.luongthuan.loginmvvm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private LoginModel loginModel;
    private LoginCallback loginCallback;

    public LoginViewModel(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
        // khởi tạo loginModel
        this.loginModel = new LoginModel();
    }


//    public LoginModel getLoginModel() {
//        return loginModel;
//    }
//
//    public void setLoginModel(LoginModel loginModel) {
//        this.loginModel = loginModel;
//    }
//
//    public LoginCallback getLoginCallback() {
//        return loginCallback;
//    }
//
//    public void setLoginCallback(LoginCallback loginCallback) {
//        this.loginCallback = loginCallback;
//    }

    public TextWatcher emailWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginModel.getEmail();
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginModel.setEmail(s.toString());
            }
        };
    }

    public TextWatcher passWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginModel.getPassword();
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginModel.setPassword(s.toString());
            }
        };
    }

    public void onClickLoginBtn(View view) {
        if (loginModel.isValid()) {
            loginCallback.onSuccess("Successfull");
        } else {
            loginCallback.onFailure("Failed");
        }
    }


}
