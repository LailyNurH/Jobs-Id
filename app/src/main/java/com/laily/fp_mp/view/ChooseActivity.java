package com.laily.fp_mp.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.laily.fp_mp.R;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);



    }
    public void Company(View view) {
        Intent intent = new Intent(this, CompanyActivity.class);
        startActivity(intent);
    }
    public void jobseek(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}