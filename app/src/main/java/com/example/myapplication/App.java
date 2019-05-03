package com.example.myapplication;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.myapplication.room.model.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database").build();
    }

}
