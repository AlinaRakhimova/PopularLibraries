package com.example.myapplication.room.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.myapplication.room.model.entity.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAll();

    @Insert
    long insert(User user);

    @Insert
    List<Long> insertList(List<User> fruits);

    @Delete
    int delete(User user);

    @Update
    int update(User user);


}

