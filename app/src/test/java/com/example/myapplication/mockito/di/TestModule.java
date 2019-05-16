package com.example.myapplication.mockito.di;

import com.example.myapplication.retrofit.model.RetrofitApi;

import org.mockito.Mockito;

import dagger.Module;
import dagger.Provides;

@Module
public class TestModule {

    @Provides
    public RetrofitApi provideRetrofitApi() {
        return Mockito.mock(RetrofitApi.class);
    }

}
