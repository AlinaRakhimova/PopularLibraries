package com.example.myapplication.observer.model;

public interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyAllObservers();

}
