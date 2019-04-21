package com.example.myapplication.observer.model;

import android.util.Log;

public class Iam implements Observer {

    private static final String TAG = "Libraries7";

    public void updateData(String name) {
        Log.d(TAG, "display: " + name + " to Iam: " + Thread.currentThread().getName());
    }

}