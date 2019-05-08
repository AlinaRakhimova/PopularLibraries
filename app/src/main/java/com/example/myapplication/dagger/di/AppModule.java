package com.example.myapplication.dagger.di;

import com.example.myapplication.dagger.Green;
import com.example.myapplication.dagger.Red;
import com.example.myapplication.dagger.White;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Red getRed() {
        return new Red();
    }

    @Provides
    @Singleton
    White getWhite() {
        return new White();
    }

    @Provides
    @Singleton
    Green getGreen() {
        return new Green();
    }

}
