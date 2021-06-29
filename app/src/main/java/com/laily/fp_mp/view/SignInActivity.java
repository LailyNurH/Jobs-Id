package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;

import com.laily.fp_mp.R;
import com.laily.fp_mp.databinding.ActivitySignInBinding;
import com.laily.fp_mp.model.User;
import com.laily.fp_mp.viewModel.UserViewModel;
import com.laily.fp_mp.viewModel.factory.UserViewModelFactory;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySignInBinding signInActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
        UserViewModel userViewModel= ViewModelProviders.of(this, new UserViewModelFactory( new User(),this)).get(UserViewModel.class);
        signInActivityBinding.setUserViewModel(userViewModel);
    }


}