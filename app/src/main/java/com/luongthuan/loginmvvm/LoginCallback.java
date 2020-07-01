package com.luongthuan.loginmvvm;

public interface LoginCallback {
    void onSuccess();

    void onFailure();

    void setErorEmail();

    void setErorPassword();
    void navigateHome();

}
