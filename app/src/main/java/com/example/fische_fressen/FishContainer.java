package com.example.fische_fressen;

import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.fische_fressen.Exceptions.BottomReachedException;
import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.Exceptions.WallReachedException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.utils.Dinner;
import com.example.fische_fressen.utils.Global;

public class FishContainer {


    public int position;
    Fish fish;

    public ImageView getFishview() {
        return fishview;
    }

    public void setFishview(ImageView fishview) {
        this.fishview = fishview;
    }

    ImageView fishview=null;
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
    public Dinner eat(FishContainer eater) throws FishCantEatOtherFishException, WallReachedException {
boolean wallreached=false;
if(this.position%5==0||(this.position+1)%5==0){
    if(eater.position+1==position||eater.position-1==position){
        wallreached=true;
    }

}
        Log.e("TAG", eater.fish.getSize()+"eat: "+this.fish.getSize());

        if(eater.fish.getSize()-1==this.fish.getSize()){
            GameStatistics.fishEaten(this.fish);
           this.fish= eater.fish;

           this.fish.grow();

           eater.fish= Global.defaultFish;

            Log.e("TAG", "current fishsize: "+this.fish.getSize() );
            Log.e("TAG", "fish eaten");

            return new Dinner(this, fish.getSize(),wallreached);
        }else if(this.fish.getSize()==-2){
            this.fish= eater.fish;


            eater.fish= Global.defaultFish;

            Log.e("TAG", "current fishsize: "+this.fish.getSize() );
            Log.e("TAG", "fish eaten");

            return new Dinner(this,1,wallreached);
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
    public boolean explode(){

        if(this.fish.getSize()!=-2){
            GameStatistics.fishExploded(this.fish);
            Global.getGameScreen().setPoints(this.fish.getSize()*20);
            Global.getGameScreen().bubble(this.fish.getSize()*2);

        }
        if(fish.getSize()==5||fish.getSize()==3){

            return true;
        }
        this.fish=Global.defaultFish;
        return false;
    }
}