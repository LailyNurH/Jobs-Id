package com.laily.fp_mp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.network.ApiClient;
import com.laily.fp_mp.network.ApiRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobRepository {
    private static final String TAG = JobRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public JobRepository() {
        apiRequest = ApiClient.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<Job>> getAllJob() {
        final MutableLiveData<List<Job>> data = new MutableLiveData<>();
        apiRequest.getAllJob()
                .enqueue(new Callback<List<Job>>() {
                    @Override
                    public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                        Log.d(TAG, "onResponse response " + response);
                        if (response.body() != null){
                            data.setValue(response.body());
                            Log.d(TAG, "onResponse: " +response.body().size());
//                            Log.d(TAG, "job " + response.body();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Job>> call, Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
    public LiveData<List<Job>> addJob(String job_title, String company, String location, String desc_job, String salary, String images) {

        final MutableLiveData<List<Job>> data = new MutableLiveData<>();

        apiRequest.addJob(job_title, company, location, desc_job, salary, images)
                .enqueue(new Callback<List<Job>>() {
                    @Override
                    public void onResponse(Call<List<Job>> call, Response<List<Job>> response) {
                        Log.d(TAG, "Add Job Succes : " + response);

                        if (response.body() != null){
                            data.setValue(response.body());

                            Log.d(TAG, "onResponse: " +response.body().size());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Job>> call, Throwable t) {
                        data.setValue(null);
                        Log.d(TAG, "Add Job Error : " + call);
                    }
                });

        return data;

    }
}

