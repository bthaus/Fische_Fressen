package com.example.fische_fressen.persistency;

import android.provider.BaseColumns;

public class Entry implements BaseColumns {
    private String TABLE_NAME = "Statistics";
    private String COLUMN_NAME_numberOfYellowFishEaten="numberOfYellowFishEaten";
    private String COLUMN_NAME_numberOfBlueFishEaten="numberOfBlueFishEaten";
    private String COLUMN_NAME_numberOfPurpleFishEaten="numberOfPurpleFishEaten";
    private String COLUMN_NAME_numberOfYellowFishExploded ="numberOfYellowFishExploded";
    private String COLUMN_NAME_numberOfBlueFishExploded= "numberOfBlueFishExploded";
    private String COLUMN_NAME_numberOfRedFishExploded="numberOfRedFishExploded";
    private String COLUMN_NAME_numberOfPurpleFishExploded ="numberOfPurpleFishExploded";
    private String COLUMN_NAME_numberOfMinesExploded="numberOfMinesExploded";
    private String COLUMN_NAME_highestPointsInOneTurn="highestPointsInOneTurn";
    private String COLUMN_NAME_totalpoints ="totalpoints";
    private String COLUMN_NAME_Highscore ="Highscore";
    private String COLUMN_NAME_movesMade ="movesMade";

    public String SQL_CREATE_TABLE =
           "CREATE TABLE "+ TABLE_NAME+" ("+
                   BaseColumns._ID +" INTEGER PRIMARY KEY, "+
           COLUMN_NAME_Highscore+ " INTEGER, "+
           COLUMN_NAME_movesMade+" INTEGER, "+
           COLUMN_NAME_highestPointsInOneTurn+" INTEGER, "+
           COLUMN_NAME_totalpoints+" INTEGER, "+
           COLUMN_NAME_numberOfYellowFishEaten +" INTEGER, "+
           COLUMN_NAME_numberOfBlueFishEaten +" INTEGER, "+
           COLUMN_NAME_numberOfPurpleFishEaten +" INTEGER, "+
           COLUMN_NAME_numberOfYellowFishExploded +" INTEGER, "+
           COLUMN_NAME_numberOfBlueFishExploded +" INTEGER, "+
           COLUMN_NAME_numberOfRedFishExploded +" INTEGER, "+
           COLUMN_NAME_numberOfPurpleFishExploded +" INTEGER, "+
           COLUMN_NAME_numberOfMinesExploded +" INTEGER );";

    public String SQL_DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME+";";


    private Entry(){
    }
    private static Entry instance;

    public static Entry getInstance(){
        if(instance == null){
            instance = new Entry();
        }
        return instance;
    }
}
