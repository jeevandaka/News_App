package com.example.mvvm_practice.repositories;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mvvm_practice.api.ApiServiceInterface;
import com.example.mvvm_practice.listeners.ApiResponseListener;
import com.example.mvvm_practice.model.DataModel;
import com.example.mvvm_practice.model.responsBody;
import com.example.mvvm_practice.utils.Constants;
import com.example.mvvm_practice.utils.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainRepositories {
    private static MainRepositories instance;
    private final int STATUS_NOT_FOUND = 404;

    private final ApiServiceInterface apiServiceInterface;

    public MainRepositories(Context context) {
        Retrofit client = RetrofitClient.getRetrofitClient();
        this.apiServiceInterface = client.create(ApiServiceInterface.class);
    }

    public static MainRepositories getInstance(Context context){
        if (instance == null){
            instance = new MainRepositories(context);
        }
        return instance;
    }
    public void getAllNews(ApiResponseListener<List<DataModel>,String> listener){
        Call<responsBody> getAllNewsCall = apiServiceInterface.getAllInNews();

        processWithNewsListCall(getAllNewsCall,listener);
    }

    private void processWithNewsListCall(Call<responsBody> call, ApiResponseListener<List<DataModel>, String> listener) {
        call.enqueue(new Callback<responsBody>() {
            @Override
            public void onResponse(@NonNull Call<responsBody> call, @NonNull Response<responsBody> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    listener.onSuccess(response.body().getArticles());
                }else if(response.code() == STATUS_NOT_FOUND){
                    listener.onFailure("Api not found");
                }else{
                    Log.e(Constants.LOG_TAG, response.message());
                    listener.onFailure(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<responsBody> call, @NonNull Throwable t) {
                t.printStackTrace();
                listener.onFailure("Unable to connect to server.");
            }
        });
    }
}
