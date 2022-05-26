package com.example.fische_fressen.utils;

import com.example.fische_fressen.FishContainer;

public class Dinner {
    public FishContainer container;
    public int points;

    public Dinner(FishContainer container, int eaten) {
        this.container = container;
        this.points = eaten;
    }
}
