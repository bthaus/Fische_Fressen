package com.example.fische_fressen;

import android.content.Intent;
import android.os.Bundle;

import com.example.fische_fressen.utils.Global;
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
        Global.playing=false;
        super.onCreate(savedInstanceState);

        binding = ActivityWinScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Global.won){
            binding.winorlose.setText(R.string.game_won);
        }else{
            binding.winorlose.setText(R.string.game_lost);
        }
        binding.totalpoints.setText(String.valueOf(Global.scorePoints));
        binding.backtomainmenue.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));





    }


}