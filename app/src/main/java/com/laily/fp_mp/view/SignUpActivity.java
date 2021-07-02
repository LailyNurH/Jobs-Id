package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.laily.fp_mp.R;
import com.laily.fp_mp.model.User;
import com.laily.fp_mp.viewModel.login.SignUpViewModel;

public class SignUpActivity extends AppCompatActivity {
    EditText uemail, upass;
    Button signup;
    SignUpViewModel signUpViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        init();

        signUpViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                uemail.setText(user.getEmail());
                upass.setText(user.getPassword());
            }
        });
        if (getIntent().getExtras().getInt("") == 1) {
            signUpViewModel.readuser(getApplicationContext());

        }
    }

    private void init() {
        uemail = findViewById(R.id.R_email);
        upass = findViewById(R.id.R_password);
        signup = findViewById(R.id.signup);
        signUpViewModel = ViewModelProviders.of(this).get(SignUpViewModel.class);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User us = new User();
                if (!uemail.getText().toString().isEmpty() && !upass.getText().toString().isEmpty()) {
                    us.setEmail(uemail.getText().toString());
                    us.setPassword(upass.getText().toString());
                    signUpViewModel.Save(getApplicationContext(), us);
                    Toast.makeText(getApplicationContext(), "User Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "You must complete the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
//
//    private void onSignupClick(View view) {

    }
