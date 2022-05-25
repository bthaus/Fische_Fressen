package com.example.fische_fressen;

import android.util.Log;

import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.utils.GlobalVariables;

public class FishContainer {

    // string course_name for storing course_name
    // and imgid for storing image id.

    public int position;
    Fish fish;
    int gone=R.drawable.ic_launcher_foreground;
    public FishContainer(int imgid,int size) {
        fish=new Fish(GlobalVariables.defaultFish);
        this.fish.setSize(size);
        this.fish.setImageID(imgid);
    }



    public int getImgid() {
        return fish.getImageID();
    }

    public void setImgid(int imgid) { this.fish.setImageID(imgid);
    }
    public FishContainer eat(FishContainer eater) throws FishCantEatOtherFishException {

        Log.e("TAG", eater.fish.getSize()+"eat: "+this.fish.getSize());

        if(eater.fish.getSize()-1==this.fish.getSize()||this.fish.getSize()==-2){
           this.fish= eater.fish;
           eater.fish=GlobalVariables.defaultFish;


        /*    this.fish.setSize(eater.fish.getSize());
            this.fish.setImageID(eater.fish.getImageID());

            eater.setImgid(gone);
            eater.fish.setSize(-2);*/
            Log.e("TAG", "current fishsize: "+this.fish.getSize() );
            Log.e("TAG", "fish eaten");

            return this;
        }else{
            throw new FishCantEatOtherFishException();
        }
    }
}