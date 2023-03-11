package com.example.mvvm_practice.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient(){
        if(retrofit == null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit = new Retrofit.Builder()
                           .baseUrl(ApiEndPoints.BASE_URL)
                           .addConverterFactory(GsonConverterFactory.create())
                           .client(client)
                           .build();
        }
        return retrofit;
    }
}
