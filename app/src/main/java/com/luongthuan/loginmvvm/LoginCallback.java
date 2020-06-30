package com.luongthuan.loginmvvm;

public interface LoginCallback {
    public void onSuccess(String notification);
    public void onFailure(String notification);

}
