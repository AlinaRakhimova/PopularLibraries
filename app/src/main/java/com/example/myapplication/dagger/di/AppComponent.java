package com.example.myapplication.dagger.di;

import com.example.myapplication.dagger.DaggerActivity;
import com.example.myapplication.dagger.Red;
import com.example.myapplication.dagger.White;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(DaggerActivity daggerActivity);

    void inject(Red red);

    void inject(White white);

}
