package com.example.myapplication.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @Expose
    @SerializedName("avatar_url")
    public String avatarUrl;

}
