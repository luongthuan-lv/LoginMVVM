package com.luongthuan.loginmvvm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;

import androidx.lifecycle.ViewModel;

public class LoginViewModel {
    private LoginModel loginModel;
    private LoginCallback loginCallback;

    public LoginViewModel(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    void login(String email, String password) {
        String gtpass = "^(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d])[\\s\\S]{6,}";
        String gtemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (email.isEmpty()) {
            loginCallback.setErorEmail();
            return;
        } else if (password.isEmpty()) {
            loginCallback.setErorPassword();
            return;
        } else if (email.matches(gtemail) && password.matches(gtpass)) {
            loginCallback.onSuccess();
            loginCallback.navigateHome();

        } else {
            loginCallback.onFailure();

        }
    }


//    public TextWatcher emailWatcher() {
//        return new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginModel.setEmail(s.toString());
//            }
//        };
//    }
//
//    public TextWatcher passWatcher() {
//        return new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                loginModel.setPassword(s.toString());
//            }
//        };
//    }
//
//    public void onClickLoginBtn(View view) {
//        if (loginModel.isValid()) {
//            loginCallback.onSuccess("Successfull");
//        } else {
//            loginCallback.onFailure("Failed");
//        }
//    }
//

}
