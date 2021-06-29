package com.laily.fp_mp.model;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.TextView;

import java.util.regex.Pattern;

public class User {
    private  String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isValidEmail(){
        if (this.email !=null && !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return true;
        }
        return false;
    }
    public  boolean isValidPassword (){
        if (this.password !=null && this.password.length()>= 6){
            return true;
        }
            return false;
    }
    public boolean isValid(){
        if (this.email.equalsIgnoreCase("laily")&& this.password.equals("19020467")){
            return  true;
        }
        return false;
    }

}
