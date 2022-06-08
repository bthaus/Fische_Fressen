package com.example.fische_fressen.GameModels;

import android.util.Log;

import com.example.fische_fressen.utils.Global;

public class GameStatistics {
    public static class EasyStatistics{
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
    }
    public static class MediumStatistics{
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



}
