package com.example.fische_fressen;

import android.graphics.Matrix;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MotionEvent;
import android.widget.GridView;

import androidx.core.view.MotionEventCompat;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.fische_fressen.databinding.ActivityGameScreenBinding;

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
 @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Log.e(DEBUG_TAG, "Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.e(DEBUG_TAG, "Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.e(DEBUG_TAG, "Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.e(DEBUG_TAG, "Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.e(DEBUG_TAG, "Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }


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




         adapter = new FishAdapter(this, fishContainerLinkedList);
        grid.setAdapter(adapter);

        Matrix matrix=grid.getMatrix();



    }
    public GameScreen getInstance(){
        return this;
    }


}