package com.laily.fp_mp.viewModel.factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.laily.fp_mp.model.User;
import com.laily.fp_mp.viewModel.UserViewModel;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private User user;
    private Context context;

    public UserViewModelFactory(User user, Context context) {
        this.user = user;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull  Class<T> modelClass) {
        return (T) new UserViewModel(user,context);
    }
}
