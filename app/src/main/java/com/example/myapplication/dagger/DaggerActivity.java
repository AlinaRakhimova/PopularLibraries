package com.example.myapplication.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.App;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    @Inject
    Green green;

    @Inject
    Red red;

    @Inject
    White white;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
    }

}
