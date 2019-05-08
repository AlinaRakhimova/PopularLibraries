package com.example.myapplication.di;

import android.support.v7.app.AppCompatActivity;

public class DIActivity extends AppCompatActivity {

    Green green = new Green();
    Red red = new Red(green);
    White white = new White(green);

}
