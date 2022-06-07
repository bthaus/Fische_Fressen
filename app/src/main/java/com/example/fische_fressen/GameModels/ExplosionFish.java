package com.example.fische_fressen.GameModels;

import com.example.fische_fressen.R;
import com.example.fische_fressen.utils.Global;

public class ExplosionFish extends Fish{
    int range;
    public ExplosionFish(){
        super.size= Global.MineSize;
        super.imageID= R.drawable.min;
    }
    enum Type{
        PufferFish,
        Mine,
    }
}
