package com.example.fische_fressen.GameModels;

import com.example.fische_fressen.utils.GlobalVariables;

public class ExplosionFish extends Fish{
    int range;
    ExplosionFish(){
        super.size= GlobalVariables.explosionrange;
    }
    enum Type{
        PufferFish,
        Mine,
    }
}
