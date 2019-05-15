package com.example.myapplication;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.myapplication.dagger.di.AppComponent;
import com.example.myapplication.dagger.di.DaggerAppComponent;
import com.example.myapplication.room.model.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;
    private static AppComponent component;

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database").build();
        component = DaggerAppComponent.create();
    }

}
