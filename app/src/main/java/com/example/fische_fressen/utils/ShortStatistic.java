package com.example.fische_fressen.utils;

public class ShortStatistic {
    private int score;
    private int id;
    private String playerName;

    public ShortStatistic(int score, int id, String playerName){
        this.score = score;
        this.id = id;
        this.playerName=playerName;
    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName(){ return playerName;}

}
