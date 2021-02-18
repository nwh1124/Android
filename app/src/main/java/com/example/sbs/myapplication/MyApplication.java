package com.example.sbs.myapplication;

import android.app.Application;

import com.example.sbs.myapplication.util.Util;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {
    public MyApplication(){
        super();

        Util.init(this);
    }
}
