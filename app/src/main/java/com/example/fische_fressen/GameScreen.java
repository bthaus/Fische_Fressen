package com.example.fische_fressen;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.core.view.MotionEventCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.GameModels.Movement;
import com.example.fische_fressen.databinding.ActivityGameScreenBinding;
import com.example.fische_fressen.utils.Dinner;
import com.example.fische_fressen.utils.Global;

import java.util.LinkedList;

public class GameScreen extends AppCompatActivity {

    private static final String DEBUG_TAG = "test";
    private AppBarConfiguration appBarConfiguration;
    private ActivityGameScreenBinding binding;
    //raster erstellen
    //container mit fischen füllen
    //spielzüge ausführen können
    //bubblebalken und score anzeigen
    //ganzes spielfeld als fragment umsetzen, je nach modus anderes fragment
    //score und spielerliste sind dann ein overlay unabhängig vom spielmodus
    FishAdapter adapter;
    int difficulty=150;
    TextView score;
    int scorepoints = 0;
    FishContainer defaultContainer = new FishContainer(R.drawable.ic_launcher_foreground, -2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Global.setGameScreen(this);
        super.onCreate(savedInstanceState);

        binding = ActivityGameScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        score = binding.scorepoints;
        GridView grid = binding.grid;
        binding.fab.setOnClickListener(view -> {
            Global.fishContainerLinkedList.clear();
            for (int i = 0; i < 25; i++) {
                Global.fishContainerLinkedList.add(new FishContainer(Global.getRandomFish()));
            }
            adapter.notifyDataSetChanged();
        });
        //LinkedList<FishContainer> fishContainerLinkedList = new LinkedList<>();
        Global.fishContainerLinkedList.clear();
        for (int i = 0; i < 25; i++) {
Global.fishContainerLinkedList.add(new FishContainer(Global.getRandomFish()));
        }

        adapter = new FishAdapter(this,  Global.fishContainerLinkedList, defaultContainer);
        adapter.setGameScreen(this);




        grid.setAdapter(adapter);
        reFiller reFiller = new reFiller();
        reFiller.start();
        Bubblebar bubblebar=new Bubblebar();
        bubblebar.start();

    }
    //to be called isntead of notifydatasetchanged because this runs on the uithread no matter where you called it from
    public void datasetchanged(){
        GameScreen.this.runOnUiThread(() -> adapter.notifyDataSetChanged());
    }

    public void win() {
        GameStatistics.setHighscore(scorepoints);
        startActivity(
                new Intent(this, MainActivity.class));
    }
    private void lose() {
        GameStatistics.setHighscore(scorepoints);
        GameStatistics.print();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onRefill() {
        adapter.notifyDataSetChanged();
    }

    public void setPoints(int points) {
        if(points!=scorepoints){
            scorepoints = scorepoints + points;
        }
        GameStatistics.addPoints(points);

        score.setText(String.valueOf(scorepoints));
    }

    public void bubble(int size) {
        binding.bubblebar.setProgress(binding.bubblebar.getProgress()+size*(difficulty/15));
    }

    public class Bubblebar extends Thread{
        boolean playing=true;
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            binding.bubblebar.setProgress(100);
            while(playing){
                try {
                    Thread.sleep(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                binding.bubblebar.setProgress(binding.bubblebar.getProgress()-1,true);
                if(binding.bubblebar.getProgress()==0){
                    lose();
                    playing=false;
                }
            }
        }
    }



    public class reFiller extends Thread {
        @Override
        public void run() {

            while (true) {
                try {
                    Log.e("TAG", "run: refiller ");
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("TAG", "refilling");

                adapter.refill();
                datasetchanged();
            }
        }
    }

    public GameScreen getInstance() {
        return this;
    }
}