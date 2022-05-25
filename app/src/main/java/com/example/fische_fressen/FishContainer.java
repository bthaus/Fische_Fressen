package com.example.fische_fressen;

import com.example.fische_fressen.GameModels.Fish;

public class FishContainer {

    // string course_name for storing course_name
    // and imgid for storing image id.


    Fish fish;

    public FishContainer(int imgid) {
        fish=new Fish();
        this.fish.setImageID(imgid);
    }



    public int getImgid() {
        return fish.getImageID();
    }

    public void setImgid(int imgid) { this.fish.setImageID(imgid);
    }
}