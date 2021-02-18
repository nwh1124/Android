package com.example.sbs.myapplication.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setLifecycleOwner(this);

        MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setVm(vm);

        setContentView(binding.getRoot());
    }

}