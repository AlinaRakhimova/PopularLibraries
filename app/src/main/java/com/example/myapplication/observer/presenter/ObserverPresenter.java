package com.example.myapplication.observer.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.observer.model.Forbes;
import com.example.myapplication.observer.model.Iam;
import com.example.myapplication.observer.view.ObserverMainView;

@InjectViewState
public class ObserverPresenter extends MvpPresenter<ObserverMainView> {

    private Forbes forbes = new Forbes();
    private Iam iam = new Iam();

    public void register() {
        forbes.registerObserver(iam);
    }

    public void unregister() {
        forbes.unregisterObserver(iam);
    }

    public void spam() {
        forbes.sendSpam("SPAM");
    }

}
