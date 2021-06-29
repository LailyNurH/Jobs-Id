package com.laily.fp_mp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.laily.fp_mp.R;
import com.laily.fp_mp.adapter.JobAdapter;
import com.laily.fp_mp.adapter.PopularAdapter;
import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.model.Popular;
import com.laily.fp_mp.viewModel.JobViewModel;
import com.laily.fp_mp.viewModel.PopularViewModel;

import java.util.List;

import static com.laily.fp_mp.util.Constant.KEY_INTENT_JOB;


public class MainActivity extends AppCompatActivity {
    private JobViewModel jobViewModel;
    private PopularViewModel popularViewModel;
    private JobAdapter jobAdapter;
    private PopularAdapter popularAdapter;
    private RecyclerView rvJob,rvhorizontal;
    private ProgressBar progressBar;
    LinearLayoutManager HorizontalLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initpopularjob();
        getAllJob();
        getAllPopular();
        setupView();
    }

    private void getAllPopular() {
        rvhorizontal.setAdapter(popularAdapter);
        popularViewModel.getPopularLiveData().observe(this, popularResponse -> {
            if (popularResponse != null) {

                List<Popular> popularResponses  = popularResponse;
                popularAdapter.submitList(popularResponses);

            }
        });
    }

    private void initpopularjob() {
        popularViewModel =ViewModelProviders.of(this).get(PopularViewModel.class);
        rvhorizontal = findViewById(R.id.horizontalRV);
        popularAdapter = new PopularAdapter();
//        rvhorizontal.setLayoutManager(new LinearLayoutManager.HORIZONTAL(this));
        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,
                false);
        rvhorizontal.setLayoutManager(HorizontalLayout);

    }

    private void setupView() {

            jobAdapter.setOnItemClickListener((view, job, position) -> {

                Intent i = new Intent(this, DetailJobActivity.class);
                i.putExtra(KEY_INTENT_JOB, job);
                startActivity(i);
            });
    }

    private void init(){
        jobViewModel = ViewModelProviders.of(this).get(JobViewModel.class);

        rvJob = findViewById(R.id.rvWebService);
        progressBar = findViewById(R.id.pbWebservice);
        jobAdapter = new JobAdapter();
        rvJob.setLayoutManager(new LinearLayoutManager(this));

    }
    private void getAllJob(){
        progressBar.setVisibility(View.VISIBLE);
        rvJob.setAdapter(jobAdapter);
        jobViewModel.getJobLiveData().observe(this, jobResponse -> {
            if (jobResponse != null) {

                List<Job> jobResponses  = jobResponse;
//                Call<List<Job>> jobResponses  = jobResponse.getJob();
                jobAdapter.setJobList(jobResponses);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}