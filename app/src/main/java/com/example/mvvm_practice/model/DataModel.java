package com.example.mvvm_practice.model;

import com.example.mvvm_practice.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    public DataModel() {
    }

    @SerializedName(Constants.AUTHOR)
    @Expose
    private String author;

    @SerializedName(Constants.TITLE)
    @Expose
    private String title;

    @SerializedName(Constants.DESCRIPTION)
    @Expose
    private String description;

    @SerializedName(Constants.URL)
    @Expose
    private String url;

    @SerializedName(Constants.URL_TO_IMAGE)
    @Expose
    private String urlToImage;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
