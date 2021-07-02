package com.laily.fp_mp.viewModel.login;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laily.fp_mp.model.User;
import com.laily.fp_mp.util.SharedPref;

import org.jetbrains.annotations.NotNull;

public class SignInViewModel extends AndroidViewModel {
    private MutableLiveData <User> user;

    public SignInViewModel(@NonNull @NotNull Application application) {
        super(application);
    }
    public LiveData <User> getUser(){
        if(user== null){
            user = new MutableLiveData<>();
        }
        return user;
    }
    public  void Login (Context context,String email, String password){
        User us = SharedPref.login(context , email,password);
        user.setValue(us);
    }
}
