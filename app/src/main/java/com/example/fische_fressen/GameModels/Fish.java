package com.example.fische_fressen.GameModels;

import android.graphics.Color;
import android.util.Log;

import com.example.fische_fressen.R;

public class Fish {




    public int getImageID() {
        return imageID;
    }
    public Fish(int ImageID, int isEmpty){
        this.imageID=ImageID;
        this.size=isEmpty;
    }
    public Fish(){

    }
    public Fish(Fish fish){
        this.size=fish.size;
        this.imageID=fish.imageID;
    }
    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public int grow() {
        if(size<3){
            fisheaten++;
            if(fisheaten==3){
                size++;
                switch (size) {
                    case 0:
                        setImageID(R.drawable.yellowfish);
                        break;
                    case 1:
                        setImageID(R.drawable.bluefish);
                        break;
                    case 2:
                        setImageID(R.drawable.purplefish);
                        break;
                    case 3:
                        setImageID(R.drawable.redfish);
                        break;
                }
                fisheaten=0;
            }


        }

return size;
    }

     int fisheaten=0;
    int imageID;
     int size;
    String ID;
    Color color;
    boolean isEmpty;



    enum fishType{

    }
}
