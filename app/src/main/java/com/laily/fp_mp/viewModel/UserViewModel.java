package com.laily.fp_mp.viewModel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laily.fp_mp.view.MainActivity;
import com.laily.fp_mp.model.User;

public class UserViewModel extends ViewModel {

    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private User user;
    private Context context;

    public UserViewModel(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    public void onLoginClick() {
        user.setEmail(email.getValue());
        user.setPassword(password.getValue());

        if (user.isValidEmail()) {
            Toast.makeText(context, "Email Salah", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidPassword()) {
            Toast.makeText(context, "Password Salah", Toast.LENGTH_SHORT).show();
        } else if (user.isValid()) {
            Toast.makeText(context, "Login Sukses", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(context,MainActivity.class);
           context.startActivity(intent);

        } else {
            Toast.makeText(context, "Email dan Password Tidak Cocok", Toast.LENGTH_SHORT).show();
        }
    }
}
