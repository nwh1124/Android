package com.example.sbs.myapplication.ui;

import android.app.Application;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.sbs.myapplication.util.Util;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
public class MainViewModel extends AndroidViewModel {
    public MutableLiveData<Integer> lvImageBackgroundColor = new MutableLiveData<>(Color.parseColor("#FFFFFF"));
    public MutableLiveData<String> lvImageUrl = new MutableLiveData<>("https://i.pravatar.cc/300?img=1");


    @Inject
    public MainViewModel(@NonNull Application application) {
        super(application);

        Util.preloadImg("https://i.pravatar.cc/300?img=3");

        Util.setTimeout(() -> {
            lvImageUrl.setValue("https://i.pravatar.cc/300?img=3");
        }, 3000);

    }

}
