package com.example.fische_fressen.GameModels;

import android.util.Log;

import com.example.fische_fressen.persistency.StatisticHelper;
import com.example.fische_fressen.utils.Difficulty;
import com.example.fische_fressen.utils.Global;
import com.example.fische_fressen.utils.StatisticBundle;

import java.util.LinkedList;

public class GameStatistics {

    public static class EasyStatistics{
        public static int getNumberOfYellowFishEaten() {
            return numberOfYellowFishEaten;
        }
        public static int getGamesWon() {
            return gamesWon;
        }

        private static int gamesWon;
        public static int getNumberOfBlueFishEaten() {
            return numberOfBlueFishEaten;
        }

        public static int getNumberOfPurpleFishEaten() {
            return numberOfPurpleFishEaten;
        }

        public static int getNumberOfYellowFishExploded() {
            return numberOfYellowFishExploded;
        }

        public static int getNumberOfBlueFishExploded() {
            return numberOfBlueFishExploded;
        }

        public static int getNumberOfPurpleFishExploded() {
            return numberOfPurpleFishExploded;
        }

        public static int getNumberOfRedFishExploded() {
            return numberOfRedFishExploded;
        }

        public static int getNumberOfMinesExploded() {
            return numberOfMinesExploded;
        }

        public static int getHighestPointsInOneTurn() {
            return highestPointsInOneTurn;
        }

        public static int getTotalpoints() {
            return totalpoints;
        }

        public static int getHighscore() {
            return Highscore;
        }

        public static int getMovesMade() {
            return movesMade;
        }

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

        private static int movesMade;



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

            Log.d("Easy"," statistics");
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

        public static void makeTurn() {
            movesMade++;
        }
    }
    public static class MediumStatistics{
        public static int getNumberOfYellowFishEaten() {
            return numberOfYellowFishEaten;
        }
        public static int getGamesWon() {
            return gamesWon;
        }

        private static int gamesWon;
        public static int getNumberOfBlueFishEaten() {
            return numberOfBlueFishEaten;
        }

        public static int getNumberOfPurpleFishEaten() {
            return numberOfPurpleFishEaten;
        }

        public static int getNumberOfYellowFishExploded() {
            return numberOfYellowFishExploded;
        }

        public static int getNumberOfBlueFishExploded() {
            return numberOfBlueFishExploded;
        }

        public static int getNumberOfPurpleFishExploded() {
            return numberOfPurpleFishExploded;
        }

        public static int getNumberOfRedFishExploded() {
            return numberOfRedFishExploded;
        }

        public static int getNumberOfMinesExploded() {
            return numberOfMinesExploded;
        }

        public static int getHighestPointsInOneTurn() {
            return highestPointsInOneTurn;
        }

        public static int getTotalpoints() {
            return totalpoints;
        }

        public static int getHighscore() {
            return Highscore;
        }

        public static int getMovesMade() {
            return movesMade;
        }

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
        private static  int movesMade;


        public static void makeTurn() {

            movesMade++;
        }
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
            Log.d("Medium"," statistics");
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
    public static class HardStatistics{
        public static int getNumberOfYellowFishEaten() {
            return numberOfYellowFishEaten;
        }
        public static int getGamesWon() {
            return gamesWon;
        }

        private static int gamesWon;
        public static int getNumberOfBlueFishEaten() {
            return numberOfBlueFishEaten;
        }

        public static int getNumberOfPurpleFishEaten() {
            return numberOfPurpleFishEaten;
        }

        public static int getNumberOfYellowFishExploded() {
            return numberOfYellowFishExploded;
        }

        public static int getNumberOfBlueFishExploded() {
            return numberOfBlueFishExploded;
        }

        public static int getNumberOfPurpleFishExploded() {
            return numberOfPurpleFishExploded;
        }

        public static int getNumberOfRedFishExploded() {
            return numberOfRedFishExploded;
        }

        public static int getNumberOfMinesExploded() {
            return numberOfMinesExploded;
        }

        public static int getHighestPointsInOneTurn() {
            return highestPointsInOneTurn;
        }

        public static int getTotalpoints() {
            return totalpoints;
        }

        public static int getHighscore() {
            return Highscore;
        }

        public static int getMovesMade() {
            return movesMade;
        }

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
        private static  int movesMade;

        public static void makeTurn() {

            movesMade++;
        }

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
            Log.d("Hard"," statistics");
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
    public static class TotalStatistics{
        public static int getNumberOfYellowFishEaten() {
            return numberOfYellowFishEaten;
        }

        public static int getNumberOfBlueFishEaten() {
            return numberOfBlueFishEaten;
        }

        public static int getNumberOfPurpleFishEaten() {
            return numberOfPurpleFishEaten;
        }

        public static int getNumberOfYellowFishExploded() {
            return numberOfYellowFishExploded;
        }

        public static int getNumberOfBlueFishExploded() {
            return numberOfBlueFishExploded;
        }

        public static int getNumberOfPurpleFishExploded() {
            return numberOfPurpleFishExploded;
        }

        public static int getNumberOfRedFishExploded() {
            return numberOfRedFishExploded;
        }

        public static int getNumberOfMinesExploded() {
            return numberOfMinesExploded;
        }

        public static int getHighestPointsInOneTurn() {
            return highestPointsInOneTurn;
        }

        public static int getTotalpoints() {
            return totalpoints;
        }

        public static int getHighscore() {
            return Highscore;
        }

        public static int getMovesMade() {
            return movesMade;
        }

        private static int numberOfYellowFishEaten;
        private static int numberOfBlueFishEaten;
        private static int numberOfPurpleFishEaten;

        public static int getGamesWon() {
            return gamesWon;
        }

        private static int gamesWon;


        private static int numberOfYellowFishExploded;
        private static int numberOfBlueFishExploded;
        private static int numberOfPurpleFishExploded;
        private static  int numberOfRedFishExploded;
        private static  int numberOfMinesExploded;

        private static  int highestPointsInOneTurn;
        private static  int totalpoints;

        private static  int Highscore;
        private static  int movesMade;

        public static void makeTurn() {

            movesMade++;
        }

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
            Log.d("total"," statistics");
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

    public static void setHighscore(int highscore){
        switch (Global.difficulty){
            case EASY:EasyStatistics.setHighscore(highscore);break;
            case MEDIUM:MediumStatistics.setHighscore(highscore);break;
            case HARD:HardStatistics.setHighscore(highscore);break;
        }
        TotalStatistics.setHighscore(highscore);
    }
    public static void fishEaten(Fish fish){
        switch (Global.difficulty){
            case EASY:EasyStatistics.fishEaten(fish);break;
            case MEDIUM:MediumStatistics.fishEaten(fish);break;
            case HARD:HardStatistics.fishEaten(fish);break;
        }
        TotalStatistics.fishEaten(fish);
    }
    public static void makeTurn(){
        switch (Global.difficulty){
            case EASY:EasyStatistics.makeTurn();break;
            case MEDIUM:MediumStatistics.makeTurn();break;
            case HARD:HardStatistics.makeTurn();break;
        }
        TotalStatistics.makeTurn();
    }
    public static void fishExploded(Fish fish){
        switch (Global.difficulty){
            case EASY:EasyStatistics.fishExploded(fish);break;
            case MEDIUM:MediumStatistics.fishExploded(fish);break;
            case HARD:HardStatistics.fishExploded(fish);break;
        }
        TotalStatistics.fishExploded(fish);
    }
    public static void addPoints(int points){
        switch (Global.difficulty){
            case EASY:EasyStatistics.addPoints(points);break;
            case MEDIUM:MediumStatistics.addPoints(points);break;
            case HARD:HardStatistics.addPoints(points);break;
        }
        TotalStatistics.addPoints(points);
    }
    public static void makePermanent(){
        EasyStatistics.makePermanent();
        MediumStatistics.makePermanent();
        HardStatistics.makePermanent();
        TotalStatistics.makePermanent();
    }
    public static void print(){
        EasyStatistics.print();
        MediumStatistics.print();
        HardStatistics.print();
        TotalStatistics.print();
    }
    public static void gameWon(){
        switch (Global.difficulty){
            case EASY:EasyStatistics.gamesWon++;break;
            case MEDIUM:MediumStatistics.gamesWon++;break;
            case HARD:HardStatistics.gamesWon++;break;
        }
        TotalStatistics.gamesWon++;
    }


    public static LinkedList<StatisticBundle> getBundles(){
        LinkedList<StatisticBundle>bundles=new LinkedList<>();

        bundles.add(new StatisticBundle("Total Statistics", ""));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Highscore:  ", Integer.toString(TotalStatistics.getHighscore())));
        bundles.add(new StatisticBundle("Games won:  ", Integer.toString(TotalStatistics.getGamesWon())));
        bundles.add(new StatisticBundle("Yellow Fish eaten: ", Integer.toString(TotalStatistics.getNumberOfYellowFishEaten())));
        bundles.add(new StatisticBundle("Blue Fish eaten: ", Integer.toString(TotalStatistics.getNumberOfBlueFishEaten())));
        bundles.add(new StatisticBundle("Purple Fish eaten: ", Integer.toString(TotalStatistics.getNumberOfPurpleFishEaten())));
        bundles.add(new StatisticBundle("Yellow Fish Exploded: ", Integer.toString(TotalStatistics.getNumberOfYellowFishExploded())));
        bundles.add(new StatisticBundle("Blue Fish Exploded: ", Integer.toString(TotalStatistics.getNumberOfBlueFishExploded())));
        bundles.add(new StatisticBundle("Purple Fish Exploded: ", Integer.toString(TotalStatistics.getNumberOfPurpleFishExploded())));
        bundles.add(new StatisticBundle("Red Fish Exploded: ", Integer.toString(TotalStatistics.getNumberOfRedFishExploded())));
        bundles.add(new StatisticBundle("Mines Exploded: ", Integer.toString(TotalStatistics.getNumberOfMinesExploded())));
        bundles.add(new StatisticBundle("Highest Points/turn: ", Integer.toString(TotalStatistics.getHighestPointsInOneTurn())));
        bundles.add(new StatisticBundle("Moves made:  ", Integer.toString(TotalStatistics.getMovesMade())));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Easy Statistics", ""));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Highscore:  ", Integer.toString(EasyStatistics.getHighscore())));
        bundles.add(new StatisticBundle("Games won:  ", Integer.toString(EasyStatistics.getGamesWon())));
        bundles.add(new StatisticBundle("Yellow Fish eaten: ", Integer.toString(EasyStatistics.getNumberOfYellowFishEaten())));
        bundles.add(new StatisticBundle("Blue Fish eaten: ", Integer.toString(EasyStatistics.getNumberOfBlueFishEaten())));
        bundles.add(new StatisticBundle("Purple Fish eaten: ", Integer.toString(EasyStatistics.getNumberOfPurpleFishEaten())));
        bundles.add(new StatisticBundle("Yellow Fish Exploded: ", Integer.toString(EasyStatistics.getNumberOfYellowFishExploded())));
        bundles.add(new StatisticBundle("Blue Fish Exploded: ", Integer.toString(EasyStatistics.getNumberOfBlueFishExploded())));
        bundles.add(new StatisticBundle("Purple Fish Exploded: ", Integer.toString(EasyStatistics.getNumberOfPurpleFishExploded())));
        bundles.add(new StatisticBundle("Red Fish Exploded: ", Integer.toString(EasyStatistics.getNumberOfRedFishExploded())));
        bundles.add(new StatisticBundle("Mines Exploded: ", Integer.toString(EasyStatistics.getNumberOfMinesExploded())));
        bundles.add(new StatisticBundle("Highest Points/turn: ", Integer.toString(EasyStatistics.getHighestPointsInOneTurn())));
        bundles.add(new StatisticBundle("Moves made:  ", Integer.toString(EasyStatistics.getMovesMade())));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Medium Statistics", ""));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Highscore:  ", Integer.toString(MediumStatistics.getHighscore())));
        bundles.add(new StatisticBundle("Games won:  ", Integer.toString(MediumStatistics.getGamesWon())));
        bundles.add(new StatisticBundle("Yellow Fish eaten: ", Integer.toString(MediumStatistics.getNumberOfYellowFishEaten())));
        bundles.add(new StatisticBundle("Blue Fish eaten: ", Integer.toString(MediumStatistics.getNumberOfBlueFishEaten())));
        bundles.add(new StatisticBundle("Purple Fish eaten: ", Integer.toString(MediumStatistics.getNumberOfPurpleFishEaten())));
        bundles.add(new StatisticBundle("Yellow Fish Exploded: ", Integer.toString(MediumStatistics.getNumberOfYellowFishExploded())));
        bundles.add(new StatisticBundle("Blue Fish Exploded: ", Integer.toString(MediumStatistics.getNumberOfBlueFishExploded())));
        bundles.add(new StatisticBundle("Purple Fish Exploded: ", Integer.toString(MediumStatistics.getNumberOfPurpleFishExploded())));
        bundles.add(new StatisticBundle("Red Fish Exploded: ", Integer.toString(MediumStatistics.getNumberOfRedFishExploded())));
        bundles.add(new StatisticBundle("Mines Exploded: ", Integer.toString(MediumStatistics.getNumberOfMinesExploded())));
        bundles.add(new StatisticBundle("Highest Points/turn: ", Integer.toString(MediumStatistics.getHighestPointsInOneTurn())));
        bundles.add(new StatisticBundle("Moves made:  ", Integer.toString(MediumStatistics.getMovesMade())));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Hard Statistics", ""));
        bundles.add(new StatisticBundle("",""));
        bundles.add(new StatisticBundle("Highscore:  ", Integer.toString(HardStatistics.getHighscore())));
        bundles.add(new StatisticBundle("Games won:  ", Integer.toString(HardStatistics.getGamesWon())));
        bundles.add(new StatisticBundle("Yellow Fish eaten: ", Integer.toString(HardStatistics.getNumberOfYellowFishEaten())));
        bundles.add(new StatisticBundle("Blue Fish eaten: ", Integer.toString(HardStatistics.getNumberOfBlueFishEaten())));
        bundles.add(new StatisticBundle("Purple Fish eaten: ", Integer.toString(HardStatistics.getNumberOfPurpleFishEaten())));
        bundles.add(new StatisticBundle("Yellow Fish Exploded: ", Integer.toString(HardStatistics.getNumberOfYellowFishExploded())));
        bundles.add(new StatisticBundle("Blue Fish Exploded: ", Integer.toString(HardStatistics.getNumberOfBlueFishExploded())));
        bundles.add(new StatisticBundle("Purple Fish Exploded: ", Integer.toString(HardStatistics.getNumberOfPurpleFishExploded())));
        bundles.add(new StatisticBundle("Red Fish Exploded: ", Integer.toString(HardStatistics.getNumberOfRedFishExploded())));
        bundles.add(new StatisticBundle("Mines Exploded: ", Integer.toString(HardStatistics.getNumberOfMinesExploded())));
        bundles.add(new StatisticBundle("Highest Points/turn: ", Integer.toString(HardStatistics.getHighestPointsInOneTurn())));
        bundles.add(new StatisticBundle("Moves made:  ", Integer.toString(HardStatistics.getMovesMade())));
        return bundles;
    }

}
