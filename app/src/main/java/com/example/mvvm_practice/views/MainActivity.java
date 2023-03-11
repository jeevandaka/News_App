package com.example.mvvm_practice.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm_practice.R;
import com.example.mvvm_practice.adapters.NewsRVAdapter;
import com.example.mvvm_practice.model.DataModel;
import com.example.mvvm_practice.viewmodel.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewsViewModel viewModel;
    private NewsRVAdapter adapter;
    private List<DataModel> dataList;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        viewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(NewsViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new NewsRVAdapter(dataList,getApplication());
        recyclerView.setAdapter(adapter);
        Log.d("title of news", "kuchh nahi mila");


        viewModel.getCurrentNewsList().observe(this, new Observer<List<DataModel>>() {
            @Override
            public void onChanged(List<DataModel> dataModels) {
                if(dataModels != null){
                    dataList = dataModels;
                    Log.d("title of news", dataModels.get(1).getTitle());
                    adapter.updateNewsList(dataList);
                }
            }
        });


    }
}