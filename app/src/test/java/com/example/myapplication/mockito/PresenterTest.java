package com.example.myapplication.mockito;

import com.example.myapplication.mockito.di.TestComponent;
import com.example.myapplication.mockito.di.TestModule;
import com.example.myapplication.retrofit.model.RetrofitApi;
import com.example.myapplication.retrofit.model.User;
import com.example.myapplication.retrofit.presenter.RetrofitPresenter;
import com.example.myapplication.retrofit.view.RetrofitView;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    private RetrofitPresenter presenter;

    @Mock
    private RetrofitView retrofitView;

    @BeforeClass
    public static void setupClass() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(
                __ -> Schedulers.trampoline());
    }

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        presenter = Mockito.spy(new RetrofitPresenter());
    }

    @Test
    public void getString_isCorrect() {
        TestComponent component = DaggerTestComponent.builder()
                .testModule(new TestModule() {

                    @Override
                    public RetrofitApi provideRetrofitApi() {
                        RetrofitApi retrofitApi = super.provideRetrofitApi();
                        User user = new User();
                        user.avatarUrl = "http://github.com/user/JackAvatar.jpg";
                        Mockito.when(retrofitApi.requestServer()).thenReturn(Observable.just(user));
                        return retrofitApi;
                    }
                }).build();

        component.inject(presenter);
        presenter.attachView(retrofitView);
        presenter.getAvatar();
        Mockito.verify(retrofitView).showAvatar("http://github.com/user/JackAvatar.jpg");
    }

}
