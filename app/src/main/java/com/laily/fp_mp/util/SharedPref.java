package com.laily.fp_mp.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.laily.fp_mp.model.User;

public class SharedPref {
    public static SharedPreferences preferences;

    private  static  SharedPreferences sp (Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences("data", 0);
        }
        return preferences;
    }
    public static  void SaveUser(Context context , User user){
        SharedPreferences preferences = sp(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email", user.getEmail());
        editor.putString("password",user.getPassword());
        editor.commit();
    }

    public  static  User readUser (Context context){
        SharedPreferences preferences = sp(context);
        String email = preferences.getString("email","-1");
        String password = preferences.getString("password","-1");
        User user = new User(email,password);
        return user;
    }
    public  static User login(Context context, String email, String password){
        User user=null;
        SharedPreferences preferences = sp(context);
        String mail=preferences.getString("mail","-1");
        String pass =preferences.getString("password","-1");

        if(email.equals(email)&& password.equals(pass)){
            user= new User(email,password);
        }
        return user;
    }
}
