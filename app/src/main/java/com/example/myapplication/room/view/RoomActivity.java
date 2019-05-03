package com.example.myapplication.room.view;

import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.myapplication.R;
import com.example.myapplication.room.presenter.RoomPresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RoomActivity extends MvpAppCompatActivity implements RoomView {

    @InjectPresenter
    RoomPresenter roomPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_user)
    public void putUser(View view) {
        roomPresenter.putUser();
    }

    @OnClick(R.id.add_list)
    public void addListUsers(View view) {
        roomPresenter.putListUser();
    }

    @OnClick(R.id.delete_user)
    public void deleteUser(View view) {
        roomPresenter.deleteData();
    }

    @OnClick(R.id.update_user)
    public void updateUser(View view) {
        roomPresenter.updateData();
    }

    @OnClick(R.id.show_users)
    public void showUsers(View view) {
        roomPresenter.getData();
    }

}
