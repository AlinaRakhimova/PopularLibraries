package com.example.myapplication.rx.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.rx.view.RxMainView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class RxPresenter extends MvpPresenter<RxMainView> {

    private static final String TAG = "Libraries7";

    private int i = 1;

    public Observable<String> getObservable() {

        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    emitter.onNext("Message " + i);
                    i++;
                }
            } catch (InterruptedException e) {
                Log.d(TAG, "getObservable: not disposed");
            }
        }).subscribeOn(Schedulers.io());
    }

}
