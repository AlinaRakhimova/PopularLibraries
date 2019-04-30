package com.example.myapplication.observer.model;

import android.util.Log;

import java.util.ArrayList;

public class Forbes implements Subject {

    private static final String TAG = "Libraries7";

    private ArrayList<Observer> arrayList;
    private String name;

    public Forbes() {
        arrayList = new ArrayList<>();
    }

    public void sendSpam(String name) {
        this.name = name;
        notifyAllObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, "registerObserver: " + Thread.currentThread().getName());
        arrayList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, "unregisterObserver: " + Thread.currentThread().getName());
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(name);
        }
    }

}
