package com.example.mvvm_practice.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_practice.listeners.ApiResponseListener;
import com.example.mvvm_practice.model.DataModel;
import com.example.mvvm_practice.repositories.MainRepositories;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {

    private final MainRepositories repo;

    private final MutableLiveData<List<DataModel>> CurrentNewsList;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        repo = MainRepositories.getInstance(application.getApplicationContext());
        CurrentNewsList = new MutableLiveData<List<DataModel>>();
    }

    public LiveData<List<DataModel>> getCurrentNewsList(){
        repo.getAllNews(new ApiResponseListener<List<DataModel>, String>() {
            @Override
            public void onSuccess(List<DataModel> response) {
                CurrentNewsList.postValue(response);
            }
            @Override
            public void onFailure(String error) {
                CurrentNewsList.postValue(null);
            }
        });
        return CurrentNewsList;
    }
}
