package com.example.myapplication.mockito.di;

import com.example.myapplication.retrofit.presenter.RetrofitPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent {

    void inject(RetrofitPresenter presenter);

}
