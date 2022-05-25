package com.example.fische_fressen;

import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;

public class FishContainer {

    // string course_name for storing course_name
    // and imgid for storing image id.


    Fish fish;
    int gone=R.drawable.ic_launcher_foreground;
    public FishContainer(int imgid,int size) {
        fish=new Fish();
        this.fish.setSize(size);
        this.fish.setImageID(imgid);
    }



    public int getImgid() {
        return fish.getImageID();
    }

    public void setImgid(int imgid) { this.fish.setImageID(imgid);
    }
    public void eat(FishContainer eater) throws FishCantEatOtherFishException {
        if(eater.fish.getSize()-1==this.fish.getSize()){
            setImgid(gone);

        }else{
            throw new FishCantEatOtherFishException();
        }
    }
}