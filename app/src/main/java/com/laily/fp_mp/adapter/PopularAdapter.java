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
import com.laily.fp_mp.model.Popular;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Callback;

import static android.content.ContentValues.TAG;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    private List<Popular> popularList = new ArrayList<>();
    private Callback.itemClick itemClick;

    public  void submitList(List<Popular> lista){
        popularList.clear();
        popularList.addAll(lista);
        notifyDataSetChanged();
    }

    public  void setOnItemClickListener(Callback.itemClick callback){
        itemClick = callback;
    }
    @NonNull
    @NotNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PopularAdapter.ViewHolder holder, int position) {
        holder.bind(popularList.get(position));
        if ((itemClick != null)) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClick.onItemClick(v,popularList.get(position),position);
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return popularList.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pJobTittle, ptvCompany,ptvSalary,ptvLocation;
        private ImageView pimage;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            pJobTittle= itemView.findViewById(R.id.pjob_title);
            ptvCompany= itemView.findViewById(R.id.pcompany);
            ptvSalary= itemView.findViewById(R.id.psalary);
            ptvLocation= itemView.findViewById(R.id.plocation);
            pimage = itemView.findViewById(R.id.pimage);

        }
        public  void bind(Popular popular){
            pJobTittle.setText(popular.getJob_title());
            ptvCompany.setText( popular.getCompany() );
            ptvSalary.setText( popular.getSalary() );
            ptvLocation.setText( popular.getLocation() );
            Glide.with(itemView)
                    .load(popular.getImages())
                    .into(pimage);
            Log.d(TAG, "popular " +popular.getCompany());

        }
    }
    interface  Callback{
        interface itemClick{
            void onItemClick(View view , Popular popular,int position);
        }
    }
}
