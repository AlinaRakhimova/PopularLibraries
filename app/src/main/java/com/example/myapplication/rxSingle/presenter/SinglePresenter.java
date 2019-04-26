package com.example.myapplication.rxSingle.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.rxSingle.view.SingleMainView;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SinglePresenter extends MvpPresenter<SingleMainView> {

    public Single<String> getSingle() {
        return Single.create((SingleOnSubscribe<String>) emitter -> emitter.onSuccess("Success!")).subscribeOn(Schedulers.io());
    }

}
