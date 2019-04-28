package com.example.myapplication.gson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "Libraries7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseJson();
    }

    private void parseJson() {
        String json = " {\"time_of_year\": summer, \"year\": 2019}";
        Gson gson = new GsonBuilder().create();
        Date date = gson.fromJson(json, Date.class);
        Log.d(TAG, "Time of year: " + date.getTimeOfYear());
        Log.d(TAG, "Year: " + date.getYear());
    }

}
