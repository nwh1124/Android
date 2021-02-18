package com.example.sbs.myapplication.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import dagger.hilt.android.scopes.ViewModelScoped;

@ViewModelScoped
public class MainViewModel extends AndroidViewModel {
    public static final String imgUrlM = "https://i.pravatar.cc/450?img=3";
    public static final String imgUrlW = "https://i.pravatar.cc/450?img=1";

    public MutableLiveData<String> lvGender = new MutableLiveData<>();
    public MutableLiveData<String> lvImageUrl = new MutableLiveData<>();

    @Inject
    public MainViewModel(@NonNull Application application) {
        super(application);

        setLvGender("W");
    }

    public void setLvGender(String gender) {
        lvGender.setValue(gender);

        if (gender.equals("M")) {
            lvImageUrl.setValue(imgUrlM);
        } else {
            lvImageUrl.setValue(imgUrlW);
        }
    }

}
