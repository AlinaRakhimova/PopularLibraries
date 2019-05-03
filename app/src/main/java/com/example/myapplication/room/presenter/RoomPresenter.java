package com.example.myapplication.room.presenter;

import android.util.Log;

import com.arellomobile.mvp.MvpPresenter;
import com.example.myapplication.App;
import com.example.myapplication.room.model.UserDao;
import com.example.myapplication.room.model.entity.User;
import com.example.myapplication.room.view.RoomView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomPresenter extends MvpPresenter<RoomView> {

    private static final String TAG = "Libraries7";

    private UserDao userDao;

    public RoomPresenter() {
        userDao = App.getAppDatabase().userDao();
    }

    public void putUser() {
        Disposable disposable = insertUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "putUser: " + id), throwable -> Log.d(TAG, "putUser: " + throwable));
    }

    private Single<Long> insertUser() {
        User user = new User();
        user.name = "Ivan";
        user.surname = "Ivanov";
        user.age = "28";

        return Single.create((SingleOnSubscribe<Long>) emitter -> {
            long id = userDao.insert(user);
            emitter.onSuccess(id);
        }).subscribeOn(Schedulers.io());
    }

    public void putListUser() {
        Disposable disposable = insertListUsers().observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "putUser: " + id), throwable -> Log.d(TAG, "putUser: " + throwable));
    }

    private Single<Long> insertListUsers() {
        User user = new User();
        user.name = "Ivan";
        user.surname = "Ivanov";
        user.age = "28";

        User user2 = new User();
        user2.name = "Petr";
        user2.surname = "Petrov";
        user2.age = "28";

        List<User> fruitList = new ArrayList<>();
        fruitList.add(user);
        fruitList.add(user2);

        return Single.create((SingleOnSubscribe<Long>) emitter -> {

            List<Long> longList = userDao.insertList(fruitList);

            emitter.onSuccess(longList.get(0));
        }).subscribeOn(Schedulers.io());
    }

    public void getData() {
        Disposable disposable = userDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> Log.d(TAG, "getData: " + users), throwable -> Log.d(TAG, "getData: " + throwable));
    }

    public void deleteData() {
        Disposable disposable = deleteUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "deleteData: " + id), throwable -> Log.d(TAG, "deleteData: " + throwable));
    }

    private Single<Integer> deleteUser() {
        User user = new User();
        user.id = 1;

        return Single.create((SingleOnSubscribe<Integer>) emitter -> {
            int position = userDao.delete(user);
            emitter.onSuccess(position);
        }).subscribeOn(Schedulers.io());
    }

    public void updateData() {
        Disposable disposable = updateUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> Log.d(TAG, "updateData: " + id), throwable -> Log.d(TAG, "updateData: " + throwable));
    }

    private Single<Integer> updateUser() {
        User user = new User();
        user.id = 2;
        user.name = "Petr";
        user.surname = "Makarov";
        user.age = "28";

        return Single.create((SingleOnSubscribe<Integer>) emmiter -> {
            int position = userDao.update(user);
            emmiter.onSuccess(position);
        }).subscribeOn(Schedulers.io());
    }
}

