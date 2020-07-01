package com.luongthuan.loginmvvm;


public class LoginModel {
    String email, password;


    public String getEmail() {
        return email;
    }

    public void setEmail( String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

//    public boolean isValid() {
//        String gtpass = "^(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z\\d])[\\s\\S]{6,}";
//        String gtemail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//     Log.e("e",email+"");
//     Log.e("p",password+"");
//        return !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)&& getPassword().matches(gtpass) && getEmail().matches(gtemail)  ;
//    }

}
