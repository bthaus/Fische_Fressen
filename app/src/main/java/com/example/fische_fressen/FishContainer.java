package com.example.fische_fressen;

import android.util.Log;

import com.example.fische_fressen.Exceptions.BottomReachedException;
import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.utils.Dinner;
import com.example.fische_fressen.utils.Global;

public class FishContainer {


    public int position;
    Fish fish;

    public FishContainer(int imgid,int size) {
        fish=new Fish(Global.defaultFish);
        this.fish.setSize(size);
        this.fish.setImageID(imgid);
    }
    public FishContainer(Fish fish) {
        this.fish=fish;
    }

    public int getImgid() {
        return fish.getImageID();
    }

    public void setImgid(int imgid) { this.fish.setImageID(imgid);
    }
    public Dinner eat(FishContainer eater) throws FishCantEatOtherFishException {

        Log.e("TAG", eater.fish.getSize()+"eat: "+this.fish.getSize());

        if(eater.fish.getSize()-1==this.fish.getSize()){

           this.fish= eater.fish;

           this.fish.grow();

           eater.fish= Global.defaultFish;

            Log.e("TAG", "current fishsize: "+this.fish.getSize() );
            Log.e("TAG", "fish eaten");

            return new Dinner(this, fish.getSize());
        }else if(this.fish.getSize()==-2){
            this.fish= eater.fish;


            eater.fish= Global.defaultFish;

            Log.e("TAG", "current fishsize: "+this.fish.getSize() );
            Log.e("TAG", "fish eaten");

            return new Dinner(this,1);
        }
        else{
            throw new FishCantEatOtherFishException();
        }
    }

    public void fall(FishContainer destination) throws BottomReachedException {
        if(this.fish.getSize()==-2){
            throw new BottomReachedException();
        }
        if(destination.fish.getSize()==-2){
            destination.fish=this.fish;
            this.fish= Global.defaultFish;
        }else{
            throw new BottomReachedException();
        }

    }
}