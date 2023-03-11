package com.example.mvvm_practice.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responsBody {

    @SerializedName("articles")
    @Expose
   private List<DataModel> articles;

    public responsBody() {
    }

    public List<DataModel> getArticles() {
        return articles;
    }

    public void setArticles(List<DataModel> articles) {
        this.articles = articles;
    }
}
