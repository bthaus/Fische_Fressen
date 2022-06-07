package com.example.fische_fressen.GameModels;

import android.util.Log;

public class GameStatistics {
  private static int numberOfYellowFishEaten;
    private static int numberOfBlueFishEaten;
    private static int numberOfPurpleFishEaten;


    private static int numberOfYellowFishExploded;
    private static int numberOfBlueFishExploded;
    private static int numberOfPurpleFishExploded;
    private static  int numberOfRedFishExploded;
    private static  int numberOfMinesExploded;

    private static  int highestPointsInOneTurn;
    private static  int totalpoints;

    private static  int Highscore;



    public static void setHighscore(int highscore){
        if(highscore>Highscore){
            Highscore=highscore;
        }
    }
    public static void fishEaten(Fish fish){
        switch (fish.getSize()){
            case 0: numberOfYellowFishEaten++;break;
            case 1:numberOfBlueFishEaten++;break;
            case 2: numberOfPurpleFishEaten++;break;
            default: break;
        }
    }

    public static void fishExploded(Fish fish){
        switch (fish.getSize()){
            case 0: numberOfYellowFishExploded++;break;
            case 1:numberOfBlueFishExploded++;break;
            case 2: numberOfPurpleFishExploded++;break;
            case 3: numberOfRedFishExploded++;break;
            case 5: numberOfMinesExploded++;break;
        }
    }
    public static void addPoints(int points){
        if(points>highestPointsInOneTurn){
            highestPointsInOneTurn=points;
        }
        totalpoints+=points;
    }
    public static void makePermanent(){
        //todo: implement
    }
    public static void print(){
        Log.d("YellowFishEaten:", String.valueOf(numberOfYellowFishEaten));
        Log.d("BlueFishEaten:", String.valueOf(numberOfBlueFishEaten));
        Log.d("PurpleFishEaten:", String.valueOf(numberOfPurpleFishEaten));
        Log.d("yellowFishSploded:", String.valueOf(numberOfYellowFishExploded));
        Log.d("bluefishsploded:", String.valueOf(numberOfBlueFishExploded));
        Log.d("purplefishsploded:", String.valueOf(numberOfPurpleFishExploded));
        Log.d("redfishsploded:", String.valueOf(numberOfRedFishExploded));
        Log.d("minesploded:", String.valueOf(numberOfMinesExploded));
        Log.d("highestpointsinoneturn:", String.valueOf(highestPointsInOneTurn));
        Log.d("totalpoints:", String.valueOf(totalpoints));
        Log.d("highscore:", String.valueOf(Highscore));
    }



}
