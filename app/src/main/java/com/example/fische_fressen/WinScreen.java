package com.example.fische_fressen;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fische_fressen.databinding.ActivityWinScreenBinding;

public class WinScreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityWinScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWinScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());






    }


}