package com.example.fische_fressen.utils;

import com.example.fische_fressen.FishContainer;
import com.example.fische_fressen.GameModels.ExplosionFish;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.GameMode;
import com.example.fische_fressen.GameScreen;
import com.example.fische_fressen.R;

import java.util.LinkedList;

public class Global {



    public static int MineSize =5;
    public static String userName;
    public static String ID;
    public static GameMode gameMode;
    public static int randomSeed;
    public static int lastClickedPosition=-1;
    public static Fish defaultFish=new Fish(R.drawable.empty,-2);
    public static int scorePoints=0;
    public static int difficultyValue=90;
    public static Difficulty difficulty=Difficulty.HARD;
    public static boolean won=false;
    public static boolean playing=false;
    public static long explosionDelay=80;
    public static int eatDelay=250;
    public static int explosionNumber;


    public static boolean isSleepytime() {
        return sleepytime;
    }
    public static void setDifficulty(Difficulty diff){
        switch (diff){
            case EASY: difficultyValue=150;break;
            case MEDIUM: difficultyValue=110;break;
            case HARD: difficultyValue=90;break;
            case GAMEJOURNALIST:difficultyValue=1000;break;
            default:break;
        }
       difficulty=diff;
    }
    public static void setSleepytime(boolean sleepytime) {

        Global.sleepytime = sleepytime;
    }

    public static boolean sleepytime=false;


    public static LinkedList<FishContainer>fishContainerLinkedList=new LinkedList<>();

    public static GameScreen getGameScreen() {
        return gameScreen;
    }

    public static void setGameScreen(GameScreen gameScreen) {
        Global.gameScreen = gameScreen;
    }

    public static GameScreen gameScreen;


    public static int getMineSize() {
        return MineSize;
    }

    public static void setMineSize(int mineSize) {
        Global.MineSize = mineSize;
    }

    public static Fish getRandomFish(){
        int rand = (int) (Math.random() * 1000);
        if(rand>950){
            return new ExplosionFish();
        }
        rand=rand%3;
        switch (rand) {

            case 0: return new Fish(R.drawable.yellowfish, 0);
            case 1: return new Fish(R.drawable.bluefish, 1);
            case 2:return new Fish(R.drawable.purplefish, 2);
            default: Global.fishContainerLinkedList.add(new FishContainer(R.drawable.icon, 5));
        }
        return new Fish(R.drawable.bluefish, 1);
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Global.userName = userName;
    }

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        Global.ID = ID;
    }

    public static GameMode getGameMode() {
        return gameMode;
    }

    public static void setGameMode(GameMode gameMode) {
        Global.gameMode = gameMode;
    }

    public static int getRandomSeed() {
        return randomSeed;
    }

    public static void setRandomSeed(int randomSeed) {
        Global.randomSeed = randomSeed;
    }

}
