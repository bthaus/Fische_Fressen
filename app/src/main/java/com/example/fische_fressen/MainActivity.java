package com.example.fische_fressen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fische_fressen.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //todo:
    //on start einen dialog öffnen um namen einzugeben
    //on start: verbindung zum server herstellen (hier bekommt man schon die unique id
    //create game
    //join game
    //evt. menü ~
    //Spielanleitung copy pasten
    //leave game button (exit button)
    //singleplayerbutton.



    public void toLobby(View view) {

        startActivity( new Intent(this,LobbyActivity.class));
    }
}