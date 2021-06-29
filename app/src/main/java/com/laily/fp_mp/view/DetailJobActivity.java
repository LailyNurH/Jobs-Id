package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laily.fp_mp.R;
import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.viewModel.JobViewModel;

import static com.laily.fp_mp.util.Constant.KEY_INTENT_JOB;


public class DetailJobActivity extends AppCompatActivity {

    ImageView dimages;
    TextView dcompany, dsalary, dtittle, ddesc;
    RelativeLayout howto;
    private JobViewModel jobViewModel;
    private String t;
    private  Integer idjob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);
        init();
        setupView();
    }

    private void init() {
        jobViewModel = ViewModelProviders.of(this).get(JobViewModel.class);
        dcompany = findViewById(R.id.dcompany);
        ddesc = findViewById(R.id.ddesc);
        dsalary = findViewById(R.id.dsalary);
        dtittle = findViewById(R.id.djob_title);
        dimages = findViewById(R.id.dimages);
        howto = findViewById(R.id.btnHowToApply);
    }

    private void setupView() {
        if (getIntent().hasExtra(KEY_INTENT_JOB)) {
            Job job = (Job) getIntent().getSerializableExtra(KEY_INTENT_JOB);

//            idoom = room.getIdRoom();
            idjob = job.getId_job();
            dcompany.setText( job.getCompany());
            ddesc.setText(job.getDesc_job());
            dtittle.setText(job.getJob_title());
            dsalary.setText(job.getSalary());

            Glide.with(DetailJobActivity.this)
                    .load(job.getImages())
                    .into(dimages);

            howto.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(job.getHow_to_apply()));
                startActivity(intent);
            });
        }
    }
}