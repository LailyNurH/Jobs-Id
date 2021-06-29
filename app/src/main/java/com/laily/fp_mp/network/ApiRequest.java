package com.laily.fp_mp.network;

import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.model.Popular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequest {

    @GET("api/job")
//    Call<Job> getAllJob();
    Call<List<Job>>getAllJob();

    @GET("api/popular")
    Call<List<Popular>> getAllPopular();

    @FormUrlEncoded
    @POST("api/job")
    Call<List<Job>> addJob(
            @Field("job_title") String job_title,
            @Field("company") String company,
            @Field("location") String location,
            @Field("desc_job") String desc_job,
            @Field("salary") String salary,
            @Field("images") String images
    );


}
