package com.example.fische_fressen.GameModels;

import com.example.fische_fressen.utils.Global;

public class ExplosionFish extends Fish{
    int range;
    ExplosionFish(){
        super.size= Global.explosionrange;
    }
    enum Type{
        PufferFish,
        Mine,
    }
}
