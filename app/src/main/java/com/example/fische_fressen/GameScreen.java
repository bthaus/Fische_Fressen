package com.example.fische_fressen;

import android.graphics.Matrix;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

import androidx.core.view.MotionEventCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.databinding.ActivityGameScreenBinding;

import java.util.LinkedList;

public class GameScreen extends AppCompatActivity   {

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

    FishContainer defaultContainer=new FishContainer(R.drawable.ic_launcher_foreground,-2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGameScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridView grid = binding.grid;

        LinkedList<FishContainer> fishContainerLinkedList = new LinkedList<>();
        for (int i = 0; i < 25; i++) {
            int rand=(int)(Math.random()*10)%4;
            switch (rand){
                case 0:   fishContainerLinkedList.add(new FishContainer(R.drawable.yellowfish,0));break;
                case 1:   fishContainerLinkedList.add(new FishContainer(R.drawable.bluefish,1));break;
                case 2:   fishContainerLinkedList.add(new FishContainer(R.drawable.redfish,3));break;
                case 3:   fishContainerLinkedList.add(new FishContainer(R.drawable.purplefish,2));break;
                default:fishContainerLinkedList.add(new FishContainer(R.drawable.icon,5));
            }
             }




         adapter = new FishAdapter(this, fishContainerLinkedList,defaultContainer);

        grid.setAdapter(adapter);
        reFiller reFiller=new reFiller();
        reFiller.start();



    }
    public void onRefill(){
        adapter.notifyDataSetChanged();
    }


    public class reFiller extends Thread
    {
        @Override
        public void run() {
            while (true) {
                try {
                    Log.e("TAG", "run: refiller " );
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("TAG", "refilling" );

                adapter.refill();



            }

        }
    }    public GameScreen getInstance(){
        return this;
    }


}