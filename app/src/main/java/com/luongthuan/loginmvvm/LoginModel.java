package com.luongthuan.loginmvvm;

import android.text.TextUtils;

import androidx.annotation.Nullable;

public class LoginModel {
    @Nullable
    String email, password;

    public LoginModel() {
    }

    public LoginModel(@Nullable String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

    public boolean isValid() {
        String gtpass = "^(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d])[\\s\\S]{6,}";
        String gtemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && getPassword().matches(gtpass) && getEmail().matches(gtemail) ;
    }

}
