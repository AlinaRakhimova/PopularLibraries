package com.example.myapplication.async.view;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.async.presenter.AsyncMainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AsyncMainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.send)
    Button send;

    @InjectPresenter
    AsyncMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        send.setOnClickListener((v) -> presenter.onClickButton());
    }

}
