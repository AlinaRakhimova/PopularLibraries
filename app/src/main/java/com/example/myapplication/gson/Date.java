package com.example.myapplication.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Date {

    @Expose
    @SerializedName("time_of_year")
    private String timeOfYear;

    @Expose
    @SerializedName("year")
    private String year;

    String getTimeOfYear() {
        return timeOfYear;
    }

    String getYear() {
        return year;
    }

}
