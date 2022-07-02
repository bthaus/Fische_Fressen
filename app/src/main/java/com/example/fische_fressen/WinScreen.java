package com.example.fische_fressen;

import android.content.Intent;
import android.os.Bundle;

import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.persistency.StatisticHelper;
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
    private StatisticHelper sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GameStatistics.makePermanent();
        Global.playing=false;
        super.onCreate(savedInstanceState);
        sh = new StatisticHelper(this);

        binding = ActivityWinScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if(Global.won){
            binding.winorlose.setText(R.string.game_won);
        }else{
            binding.winorlose.setText(R.string.game_lost);
        }
        sh.addStatistic(GameStatistics.TotalStatistics.getHighscore(), GameStatistics.TotalStatistics.getMovesMade(),GameStatistics.TotalStatistics.getHighestPointsInOneTurn(), GameStatistics.TotalStatistics.getTotalpoints(),GameStatistics.TotalStatistics.getNumberOfYellowFishEaten(),  GameStatistics.TotalStatistics.getNumberOfBlueFishEaten(),GameStatistics.TotalStatistics.getNumberOfPurpleFishEaten(),GameStatistics.TotalStatistics.getNumberOfYellowFishExploded(),GameStatistics.TotalStatistics.getNumberOfBlueFishExploded(), GameStatistics.TotalStatistics.getNumberOfRedFishExploded(),GameStatistics.TotalStatistics.getNumberOfPurpleFishExploded(),GameStatistics.TotalStatistics.getNumberOfMinesExploded());
        binding.totalpoints.setText(String.valueOf(Global.scorePoints));
        GameStatistics.reset();
        binding.backtomainmenue.setOnClickListener(view -> startActivity(new Intent(view.getContext(), MainActivity.class)));

    }


}