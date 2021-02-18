package com.example.sbs.myapplication.util;

import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Util {
    private static Application application;

    public static void init(Application application) {
        Util.application = application;
    }

    public static void setTimeout(Runnable r, int delayMillis) {
        new android.os.Handler().postDelayed(r, delayMillis);
    }

    public static void log(String msg){
        Log.d("AA1", msg);
    }

    public static float dipToPixels(int borderRadius) {
        DisplayMetrics metrics = application.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, borderRadius, metrics);
    }

    public static void preloadImg(String imgUrl) {
        Glide.with(application)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .preload();
    }
}
