package com.example.fische_fressen;

import android.os.Bundle;

import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.utils.MyRecyclerViewAdapter;
import com.example.fische_fressen.utils.StatisticBundle;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fische_fressen.databinding.ActivityStatisticScreenBinding;

import java.util.ArrayList;
import java.util.LinkedList;

public class StatisticScreen extends AppCompatActivity  {
    MyRecyclerViewAdapter adapter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityStatisticScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStatisticScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinkedList<StatisticBundle> bundles=new LinkedList<>();
        bundles.add(new StatisticBundle("RedFish Popped", Integer.toString(GameStatistics.TotalStatistics.getNumberOfRedFishExploded())));
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, bundles);

        recyclerView.setAdapter(adapter);
    }



}