package com.example.myapplication.dagger;

import com.example.myapplication.App;

import javax.inject.Inject;

public class Red {

    @Inject
    Green green;

    public Red() {
        App.getComponent().inject(this);
        System.out.println("Red: ");
        green.show();
    }

}
