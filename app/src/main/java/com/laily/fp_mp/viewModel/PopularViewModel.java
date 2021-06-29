package com.laily.fp_mp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.laily.fp_mp.Repository.PopularRepository;
import com.laily.fp_mp.model.Popular;

import java.util.List;

public class PopularViewModel extends AndroidViewModel {

    private PopularRepository popularRepository;
    private LiveData<List<Popular>> getPopularLiveData;

    public PopularViewModel(@NonNull Application application) {
        super(application);

        popularRepository = new PopularRepository();
        this.getPopularLiveData = popularRepository.getAllPopular();
    }

    public LiveData<List<Popular>> getPopularLiveData() {
        this.getPopularLiveData = popularRepository.getAllPopular();
        return getPopularLiveData;



    }
}