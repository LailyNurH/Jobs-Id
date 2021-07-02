package com.laily.fp_mp.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.laily.fp_mp.R;
import com.laily.fp_mp.model.Job;
import com.laily.fp_mp.util.Constant;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit2.http.Tag;

import static android.content.ContentValues.TAG;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {

    private List<Job> jobList = new ArrayList<>();
    private Callback.ItemClick itemClick;


    public  void setJobList(List<Job> list){
        jobList.clear();
        jobList.addAll(list);
        notifyDataSetChanged();
    }
    public void setOnItemClickListener(Callback.ItemClick callback){
        itemClick = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(jobList.get(position));

        if (itemClick != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick.onItemClick(v, jobList.get(position), position);
                    Log.d(TAG, "deskripsi  " +jobList.get(position).getDesc_job());


                }
            });
        }


}
    @Override
    public int getItemCount() {
        return jobList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvJobTittle, tvCompany,tvSalary,tvLocation;
        private ImageView ivJob;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvJobTittle = itemView.findViewById(R.id.tvTittleHome);
            tvCompany = itemView.findViewById(R.id.tvCompanyHome);
            ivJob = itemView.findViewById(R.id.ivJobHome);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvSalary = itemView.findViewById(R.id.tvSalary);
        }

        public void bind(Job job){
            tvJobTittle.setText(job.getJob_title());
            tvCompany.setText( job.getCompany() );
            tvSalary.setText( job.getSalary() );
            tvLocation.setText( job.getLocation() );
            Glide.with(itemView)
                    .load(job.getImages())
                    .into(ivJob);
            Log.d(TAG, "test image" +job.getImages());
        }
    }

    interface Callback {
        interface ItemClick {
            void onItemClick(View view, Job job, int position);
            
        }
    }
}
