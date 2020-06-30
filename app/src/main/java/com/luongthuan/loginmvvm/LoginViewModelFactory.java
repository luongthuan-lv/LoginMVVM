package com.luongthuan.loginmvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
  private LoginCallback loginCallback;

    public LoginViewModelFactory(LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginCallback);
    }
}
