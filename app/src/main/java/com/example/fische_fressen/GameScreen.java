package com.example.fische_fressen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.ui.AppBarConfiguration;


import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.databinding.ActivityGameScreenBinding;
import com.example.fische_fressen.utils.Global;

public class GameScreen extends AppCompatActivity implements SensorEventListener {

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
    int difficulty = Global.difficultyValue;
    TextView score;
    int scorepoints = 0;
    FishContainer defaultContainer = new FishContainer(R.drawable.ic_launcher_foreground, -2);

    Bubblebar bubblebar;

    private SensorManager sensorManager;
    private Sensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Global.playing = true;
        Global.setGameScreen(this);
        super.onCreate(savedInstanceState);

        binding = ActivityGameScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //light sensor variables
        sensorManager = (SensorManager) (getSystemService(Context.SENSOR_SERVICE));
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        //light sensor variables end
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

        adapter = new FishAdapter(this, Global.fishContainerLinkedList, defaultContainer);
        adapter.setGameScreen(this);


        grid.setAdapter(adapter);
        bubblebar = new Bubblebar();
        bubblebar.start();


    }

    //to be called isntead of notifydatasetchanged because this runs on the uithread no matter where you called it from
    public void datasetchanged() {
        GameScreen.this.runOnUiThread(() -> adapter.notifyDataSetChanged());

    }
    public void animate(AnimationDrawable animation){
        GameScreen.this.runOnUiThread(animation::start);

    }
    public void setBackgroundRessource(int ressource, ImageView imageView){
        GameScreen.this.runOnUiThread(() -> imageView.setBackgroundResource(ressource));

    }

    public void win() {
        GameStatistics.setHighscore(scorepoints);
        Global.won = true;
        GameStatistics.gameWon();
        Global.scorePoints = scorepoints;
        startActivity(
                new Intent(this, WinScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    private void lose() {
        GameStatistics.setHighscore(scorepoints);
        GameStatistics.print();
        Global.scorePoints = scorepoints;
        Global.won = false;
        startActivity(
                new Intent(this, WinScreen.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    public void onRefill() {
        adapter.notifyDataSetChanged();
    }

    public void setPoints(int points) {
        int factor=1;
        switch (Global.difficulty){
            case HARD:factor=3;break;
            case EASY:factor=1;break;
            case MEDIUM: factor=2;break;
        }
        if (points != scorepoints) {
            scorepoints = scorepoints + points*factor;
        }
        GameStatistics.addPoints(points);

        GameScreen.this.runOnUiThread(() -> score.setText(String.valueOf(scorepoints)));
    }

    public void bubble(int size) {
        binding.bubblebar.setProgress(binding.bubblebar.getProgress() + size * (difficulty / 15));
    }

    public void setImageRessource(ImageView fishview, int empty) {
        GameScreen.this.runOnUiThread(() -> fishview.setImageResource(empty));
    }

    public class Bubblebar extends Thread {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            binding.bubblebar.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);
            binding.bubblebar.setProgress(100);
            while (Global.playing) {
                try {
                    Thread.sleep(difficulty);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                binding.bubblebar.setProgress(binding.bubblebar.getProgress() - 1, true);
                if (binding.bubblebar.getProgress() == 0) {
                    Global.playing = false;
                    lose();
                }
            }
        }
    }




    public GameScreen getInstance() {
        return this;
    }

    //Light Sensor
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            float lightValue = sensorEvent.values[0];
            if (lightValue < 200) {
                //No need to redraw fish if sleepyTime was true all the time
                if (Global.isSleepytime() != true) {
                    Global.setSleepytime(true);
                    adapter.redrawAssets();
                    adapter.notifyDataSetChanged();
                }
            } else {
                if (Global.isSleepytime() != false) {
                    Global.setSleepytime(false);
                    adapter.redrawAssets();
                    adapter.notifyDataSetChanged();
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.i("Sensors", "Accuracy of sensor ${p0?.name} changed to p1");
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    //Light Sensor end
}