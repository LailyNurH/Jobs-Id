package com.laily.fp_mp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.model.Popular;
import com.laily.fp_mp.network.ApiClient;
import com.laily.fp_mp.network.ApiRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularRepository {  private static final String TAG = PopularRepository.class.getSimpleName();
    private ApiRequest apiRequestt;

    public PopularRepository() {
        apiRequestt = ApiClient.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<List<Popular>> getAllPopular() {
        final MutableLiveData<List<Popular>> datap = new MutableLiveData<>();
        apiRequestt.getAllPopular()
                .enqueue(new Callback<List<Popular>>() {
                    @Override
                    public void onResponse(Call<List<Popular>> call, Response<List<Popular>> response) {
                        Log.d(TAG, "onResponse response " + response);
                        if (response.body() != null){
                            datap.setValue(response.body());
                            Log.d(TAG, "onResponse p: " +response.body().size());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Popular>> call, Throwable t) {
                        datap.setValue(null);

                    }
                });
        return datap;
    }
}
