package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.laily.fp_mp.R;
import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.viewModel.JobViewModel;

import static com.laily.fp_mp.util.Constant.KEY_INTENT_JOB;

public class CompanyActivity extends AppCompatActivity {
    private EditText etJobTitle, etCompany, etSalary, etDesc,etImageurl,etLocation;
//    private TextView tvNama;
    private Button btnAdd,btnSee;
    private ProgressBar progressBar;
    private JobViewModel jobViewModel;
    private  Integer id_job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        init();
        setup();
    }


    private void init(){
        jobViewModel = ViewModelProviders.of(this).get(JobViewModel.class);

        etJobTitle = findViewById(R.id.etJob);
        etCompany = findViewById(R.id.etCompany);
        etSalary = findViewById(R.id.etSalary);
        etDesc = findViewById(R.id.etDeskripsi);
        btnAdd = findViewById(R.id.btnAddJob);
        etImageurl = findViewById(R.id.etImageUrl);
        etLocation = findViewById(R.id.etLocation);
        btnSee = findViewById(R.id.btnSeeJob);

        btnSee.setOnClickListener(v -> {

            Intent intent = new Intent(CompanyActivity.this, MainActivity.class);
            startActivity(intent);

        });
    }

    private void setup() {
        if(getIntent().hasExtra(KEY_INTENT_JOB)){
            Job job = (Job) getIntent().getSerializableExtra(KEY_INTENT_JOB);

            etJobTitle.setText(job.getJob_title());
            etCompany.setText( job.getCompany() );
            etSalary.setText( job.getSalary() );
            etLocation.setText( job.getLocation() );
            etImageurl.setText(job.getId_job());
            etDesc.setText(job.getDesc_job());
            btnAdd.setText("Add Job");
            id_job = job.getId_job();
            addJob(false);
        } else{
            addJob (true);
        }
    }
    private void addJob(Boolean addJob){
        btnAdd.setOnClickListener(v ->{
            Toast.makeText(getApplicationContext(), "Add Job Successful", Toast.LENGTH_SHORT).show();
            String namaJob = etJobTitle.getText().toString();
            String company = etCompany.getText().toString();
            String salary = etSalary.getText().toString();
            String location = etLocation.getText().toString();
            String images = etImageurl.getText().toString();
            String desc_job= etDesc.getText().toString();

            if (addJob){
                jobViewModel.addJob(namaJob, company, location, desc_job, salary, images).observe(this, addJobResponses -> {
                    if (addJobResponses != null){
                    }
                });
            }else {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }

        });
    }
}