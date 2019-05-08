package com.example.myapplication.dagger;

import com.example.myapplication.App;

import javax.inject.Inject;

public class White {

    @Inject
    Green green;

    public White() {
        App.getComponent().inject(this);
        System.out.println("White: ");
        green.show();
    }

}
