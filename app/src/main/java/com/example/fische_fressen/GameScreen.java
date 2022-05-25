package com.example.fische_fressen;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fische_fressen.databinding.ActivityGameScreenBinding;

import java.util.ArrayList;
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
CourseGVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGameScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GridView grid = binding.grid;

        LinkedList<CourseModel> courseModelArrayList = new LinkedList<>();
        for (int i = 0; i < 25; i++) {
            courseModelArrayList.add(new CourseModel(R.drawable.icon));
        }




         adapter = new CourseGVAdapter(this, courseModelArrayList);
        grid.setAdapter(adapter);

        Matrix matrix=grid.getMatrix();


    }
    public GameScreen getInstance(){
        return this;
    }
    public  void remove(CourseModel courseModel){

        adapter.remove(courseModel);



    }

}