package com.example.mvvm_practice.listeners;

public interface ApiResponseListener<X,Y> {

    void onSuccess(X response);

    void onFailure(Y error);
}
