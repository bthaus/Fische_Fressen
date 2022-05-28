package com.example.fische_fressen.GameModels;

public class Movement {
    Position position;
   public  enum Direction{
        RIGHT(1),
        LEFT(-1),
        UP(-5),
        DOWN(5);

       private Direction(int directionValue){
            this.directionOffset = directionValue;
       }

       private int directionOffset;

       public int getDirectionOffset() {
           return directionOffset;
       }
   }

}
