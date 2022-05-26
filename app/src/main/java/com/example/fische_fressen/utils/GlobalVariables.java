package com.example.fische_fressen.utils;

import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.GameMode;
import com.example.fische_fressen.R;

public class GlobalVariables {


    public static int difficulty;
    public static int explosionrange;
    public static String userName;
    public static String ID;
    public static GameMode gameMode;
    public static int randomSeed;
    public static int lastClickedPosition=-1;
    public static Fish defaultFish=new Fish(R.drawable.ic_launcher_foreground,-2);

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int difficulty) {
        GlobalVariables.difficulty = difficulty;
    }

    public static int getExplosionrange() {
        return explosionrange;
    }

    public static void setExplosionrange(int explosionrange) {
        GlobalVariables.explosionrange = explosionrange;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        GlobalVariables.userName = userName;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        GlobalVariables.ID = ID;
    }

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        GlobalVariables.gameMode = gameMode;
    }

    public static int getRandomSeed() {
        return randomSeed;
    }

    public static void setRandomSeed(int randomSeed) {
        GlobalVariables.randomSeed = randomSeed;
    }

}
