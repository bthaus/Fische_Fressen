package com.example.fische_fressen.utils;

import com.example.fische_fressen.FishContainer;

public class Dinner {
    public FishContainer container;
    public int points;
   public  boolean wallreached;

    public Dinner(FishContainer container, int eaten,boolean wallreached) {
        this.container = container;
        this.points = eaten;
        this.wallreached=wallreached;
    }
}
