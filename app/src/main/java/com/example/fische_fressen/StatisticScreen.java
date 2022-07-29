package com.example.fische_fressen;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.fische_fressen.persistency.StatisticHelper;
import com.example.fische_fressen.utils.StatisticsRecyclerViewAdapter;
import com.example.fische_fressen.utils.StatisticBundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Toast;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fische_fressen.databinding.ActivityStatisticScreenBinding;

import java.util.LinkedList;

public class StatisticScreen extends AppCompatActivity  {
    StatisticsRecyclerViewAdapter adapter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityStatisticScreenBinding binding;
    Intent intent;
    int id;
    StatisticHelper sh;
    LinkedList<StatisticBundle> bundles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatisticScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        intent = getIntent();
        id = intent.getIntExtra("id",-1);
        if(id == -1){
            //Error code, stop activity
            Toast.makeText(this,"ERROR LOADING DATA", Toast.LENGTH_LONG);
        }
        else{
            sh = new StatisticHelper(this);
            Cursor c = sh.readSingleStatistic(id);
            c.moveToNext();
            bundles = new LinkedList<>();
            bundles.add(new StatisticBundle("Statistic", "#"+Integer.toString(c.getInt(0))));
            bundles.add(new StatisticBundle("Player",c.getString(13)));
            bundles.add(new StatisticBundle("",""));
            bundles.add(new StatisticBundle("Highscore:  ", Integer.toString(c.getInt(1))));
            bundles.add(new StatisticBundle("Moves made:  ", Integer.toString(c.getInt(2))));
            bundles.add(new StatisticBundle("Highest Points/turn: ", Integer.toString(c.getInt(3))));
            bundles.add(new StatisticBundle("Total Points: ", Integer.toString(c.getInt(4))));
            bundles.add(new StatisticBundle("Yellow Fish eaten: ", Integer.toString(c.getInt(5))));
            bundles.add(new StatisticBundle("Blue Fish eaten: ", Integer.toString(c.getInt(6))));
            bundles.add(new StatisticBundle("Purple Fish eaten: ", Integer.toString(c.getInt(7))));
            bundles.add(new StatisticBundle("Yellow Fish Exploded: ", Integer.toString(c.getInt(8))));
            bundles.add(new StatisticBundle("Blue Fish Exploded: ", Integer.toString(c.getInt(9))));
            bundles.add(new StatisticBundle("Purple Fish Exploded: ", Integer.toString(c.getInt(10))));
            bundles.add(new StatisticBundle("Red Fish Exploded: ", Integer.toString(c.getInt(11))));
            bundles.add(new StatisticBundle("Mines Exploded: ", Integer.toString(c.getInt(12))));
            bundles.add(new StatisticBundle("",""));
        }


        // set up the RecyclerView
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StatisticsRecyclerViewAdapter(this, bundles);

        recyclerView.setAdapter(adapter);
    }



}