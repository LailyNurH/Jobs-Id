package com.laily.fp_mp.viewModel.login;

import android.app.Application;
import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laily.fp_mp.model.User;
import com.laily.fp_mp.util.SharedPref;

import org.jetbrains.annotations.NotNull;

public class SignUpViewModel extends AndroidViewModel {


    public SignUpViewModel(@NonNull @NotNull Application application) {
        super(application);
    }

    private MutableLiveData <User> user;
    public LiveData <User> getUser (){
        if ( user == null){
            user = new MutableLiveData<>();
        }
        return user;
    }
    public  void Save(Context context,User user){
        SharedPref.SaveUser(context, user);
    }
    public  void readuser (Context context){
        User us = SharedPref.readUser(context);
        user.setValue(us);
    }


}
