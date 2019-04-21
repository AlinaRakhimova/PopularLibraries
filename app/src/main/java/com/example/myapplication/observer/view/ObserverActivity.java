package com.example.myapplication.observer.view;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.observer.presenter.ObserverPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ObserverActivity extends MvpAppCompatActivity implements ObserverMainView {

    @BindView(R.id.register)
    Button register;

    @BindView(R.id.unregister)
    Button unregister;

    @BindView(R.id.send)
    Button send;

    @InjectPresenter
    ObserverPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_observer);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        register.setOnClickListener((v -> register()));
        unregister.setOnClickListener((v -> unregister()));
        send.setOnClickListener((v -> spam()));
    }

    public void register() {
        presenter.register();
    }

    public void unregister() {
        presenter.unregister();
    }

    public void spam() {
        presenter.spam();
    }

}
