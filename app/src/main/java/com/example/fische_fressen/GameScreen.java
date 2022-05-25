package com.example.fische_fressen;

import android.graphics.Matrix;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.GridView;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.fische_fressen.databinding.ActivityGameScreenBinding;

import java.util.LinkedList;

public class GameScreen extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGameScreenBinding binding;
//raster erstellen
    //container mit fischen füllen
    //spielzüge ausführen können
    //bubblebalken und score anzeigen
    //ganzes spielfeld als fragment umsetzen, je nach modus anderes fragment
    //score und spielerliste sind dann ein overlay unabhängig vom spielmodus
FishAdapter adapter;
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
                case 0:   fishContainerLinkedList.add(new FishContainer(R.drawable.yellowfish));break;
                case 1:   fishContainerLinkedList.add(new FishContainer(R.drawable.bluefish));break;
                case 2:   fishContainerLinkedList.add(new FishContainer(R.drawable.redfish));break;
                case 3:   fishContainerLinkedList.add(new FishContainer(R.drawable.purplefish));break;
                default:fishContainerLinkedList.add(new FishContainer(R.drawable.icon));
            }
             }




         adapter = new FishAdapter(this, fishContainerLinkedList);
        grid.setAdapter(adapter);

        Matrix matrix=grid.getMatrix();



    }
    public GameScreen getInstance(){
        return this;
    }


}