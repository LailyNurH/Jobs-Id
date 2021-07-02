package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.laily.fp_mp.R;

import com.laily.fp_mp.model.User;
import com.laily.fp_mp.viewModel.login.SignInViewModel;

public class SignInActivity extends AppCompatActivity {
    private EditText lpass, lemail;
    private SignInViewModel signInViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        init();

        signInViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (user != null) {
                    Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
                    intent.putExtra("", 1);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), " User Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init() {
        lemail = findViewById(R.id.etEmail);
        lpass = findViewById(R.id.etPass);
        signInViewModel = ViewModelProviders.of(this).get(SignInViewModel.class);
    }

    public void onLoginClick(View view) {
        String email = lemail.getText().toString();
        String pass = lpass.getText().toString();
        if (!email.isEmpty() && !pass.isEmpty()) {
            signInViewModel.Login(this, email, pass);
        } else {
            Toast.makeText(getApplicationContext(), "You must complete the fields", Toast.LENGTH_SHORT).show();
        }

    }

    public void txSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        intent.putExtra("SignUp", 0);
        startActivity(intent);
    }


}