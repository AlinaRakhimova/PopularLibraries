package com.example.myapplication.rxSingle.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.rxSingle.presenter.SinglePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;

public class SingleActivity extends MvpAppCompatActivity implements SingleMainView {

    private static final String TAG = "Libraries7";

    @BindView(R.id.send)
    Button send;

    @InjectPresenter
    SinglePresenter presenter;

    private Single<String> single;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        single = presenter.getSingle();
    }

    @OnClick(R.id.send)
    public void register(View view) {
        single.observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableSingleObserver<String>() {

            @Override
            public void onSuccess(String s) {
                Log.d(TAG, s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "Error!");
            }
        });
    }

}
