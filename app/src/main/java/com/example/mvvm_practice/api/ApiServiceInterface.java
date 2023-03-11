package com.example.mvvm_practice.api;

import com.example.mvvm_practice.model.DataModel;
import com.example.mvvm_practice.model.responsBody;
import com.example.mvvm_practice.utils.ApiEndPoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceInterface {

    @GET(ApiEndPoints.GET_TOP_HEADLINES_US)
    Call<responsBody> getAllUsNews();

    @GET(ApiEndPoints.GET_TOP_HEADLINES_IN)
    Call<responsBody> getAllInNews();

}
