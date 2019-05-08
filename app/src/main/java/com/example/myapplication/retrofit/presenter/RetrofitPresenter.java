package com.example.myapplication.retrofit.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.retrofit.model.RetrofitApi;
import com.example.myapplication.retrofit.model.User;
import com.example.myapplication.retrofit.view.RetrofitView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class RetrofitPresenter extends MvpPresenter<RetrofitView> {

    private static final String TAG = "Libraries7";

    private RetrofitApi retrofitApi;

    public RetrofitPresenter() {
        retrofitApi = new RetrofitApi();
    }

    public void getAvatar() {
        Observable<User> observable = retrofitApi.requestServer();

        Disposable disposable = observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> getViewState().showAvatar(user.avatarUrl), throwable -> Log.e(TAG, "onError:" + throwable.getMessage()));
    }

}
