package com.laily.fp_mp.viewModel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.laily.fp_mp.Repository.JobRepository;
import com.laily.fp_mp.model.Job;


import java.util.List;

public class JobViewModel extends AndroidViewModel {

    private JobRepository jobRepository;
    private LiveData<List<Job>> getJobLiveData;

    public JobViewModel(@NonNull Application application) {
        super(application);

        jobRepository = new JobRepository();
        this.getJobLiveData = jobRepository.getAllJob();
    }

    public LiveData<List<Job>>getJobLiveData() {
        this.getJobLiveData = jobRepository.getAllJob();
        return getJobLiveData;
    }
    public  LiveData<List<Job>> addJob(String job_title, String company, String location, String desc_job, String salary, String images ){
        return jobRepository.addJob(job_title, company, location, desc_job, salary, images);
    }
}
