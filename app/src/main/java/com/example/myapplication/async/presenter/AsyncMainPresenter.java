package com.example.myapplication.async.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.async.service.MyAsyncTask;
import com.example.myapplication.async.view.MainView;

@InjectViewState
public class AsyncMainPresenter extends MvpPresenter<MainView> {

    private static String TAG = "Libraries7";

    public AsyncMainPresenter() {
    }

    public void onClickButton() {
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        Log.d(TAG, "method completed: " + Thread.currentThread().getName());
    }

}
