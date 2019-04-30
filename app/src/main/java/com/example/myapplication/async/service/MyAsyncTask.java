package com.example.myapplication.async.service;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {

    private static String TAG = "Libraries7";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                Log.d(TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

}
