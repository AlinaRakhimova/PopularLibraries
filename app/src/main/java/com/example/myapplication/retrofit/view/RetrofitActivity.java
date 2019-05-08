package com.example.myapplication.retrofit.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.retrofit.presenter.RetrofitPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends MvpAppCompatActivity implements RetrofitView {

    @InjectPresenter
    RetrofitPresenter retrofitPresenter;

    @BindView(R.id.avatar)
    ImageView avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.send)
    public void onClickButton(View view) {
        retrofitPresenter.getAvatar();
    }

    @Override
    public void showAvatar(String avatarUrl) {
        Glide.with(this)
                .load(avatarUrl)
                .into(avatar);
    }

}
