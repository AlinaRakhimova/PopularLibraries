package com.example.myapplication.rx.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.rx.presenter.RxPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RxActivity extends MvpAppCompatActivity implements RxMainView {

    private static final String TAG = "Libraries7";

    @BindView(R.id.register)
    Button register;

    @BindView(R.id.unregister)
    Button unregister;

    @InjectPresenter
    RxPresenter presenter;

    private Observable<String> observable;
    private Disposable disposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rx);
        ButterKnife.bind(this);
        initUI();
        observable = presenter.getObservable();
    }

    private void initUI() {
        register.setOnClickListener((v -> register(register)));
        unregister.setOnClickListener((v -> unregister(unregister)));
    }

    public void register(View view) {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe: ");
                RxActivity.this.disposable = disposable;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    public void unregister(View view) {
        disposable.dispose();
    }

}
