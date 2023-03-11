package com.example.mvvm_practice.adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm_practice.R;
import com.example.mvvm_practice.model.DataModel;
import com.example.mvvm_practice.viewmodel.NewsViewModel;

import java.util.List;

public class NewsRVAdapter extends RecyclerView.Adapter<NewsRVAdapter.recyclerViewHolder> {

    private List<DataModel> newsList;
    private final Application application;

    public void updateNewsList(List<DataModel> list){
        this.newsList = list;
        notifyDataSetChanged();
    }
    public NewsRVAdapter(List<DataModel> newsList, Application application) {
        this.newsList = newsList;
        this.application = application;
    }

    @NonNull
    @Override
    public NewsRVAdapter.recyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        return new NewsRVAdapter.recyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRVAdapter.recyclerViewHolder holder, int position) {
        DataModel dataModel = newsList.get(position);
        holder.title.setText(dataModel.getTitle());
        holder.description.setText(dataModel.getDescription());

        if (dataModel.getUrlToImage() != null) {
            String imageUrl = dataModel.getUrlToImage()
                    .replace("http://", "https://");

            Glide.with(holder.itemView)
                    .load(imageUrl)
                    .into(holder.newsImg);
        }

    }

    @Override
    public int getItemCount() {
        if(newsList == null){
            return 0;
        }
        return newsList.size();
    }

    public class recyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView description;
        private ImageView newsImg;
        public recyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            newsImg = itemView.findViewById(R.id.img);
        }
    }
}
