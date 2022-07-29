package com.example.fische_fressen.GameModels;

import android.graphics.Color;
import android.util.Log;

import com.example.fische_fressen.R;
import com.example.fische_fressen.utils.Global;

public class Fish {




    public int getImageID() {
        return imageID;
    }
    public Fish(int ImageID, int isEmpty){
        this.setImageID(ImageID);
        this.size=isEmpty;
    }

    public Fish(){

    }
    public Fish(Fish fish){
        this.size=fish.size;
        setImageID(fish.imageID);
    }
    public void setImageID(int imageID) {

        if(Global.isSleepytime()){
            switch (imageID){
                case R.drawable.bluefish :imageID=R.drawable.bluefishsleeps;break;
                case R.drawable.bluefishselected: imageID=R.drawable.bluefishselectedsleeps;break;

                case R.drawable.purplefish :imageID=R.drawable.purplefishsleeps;break;
                case R.drawable.purplefishselected :imageID=R.drawable.purplefishselectedsleeps;break;

                case R.drawable.redfish :imageID=R.drawable.redfishsleeps;break;
                case R.drawable.redfishselected: imageID=R.drawable.redfishselectedsleeps;break;

                case R.drawable.yellowfish :imageID=R.drawable.yellowfishsleeps;break;
                case R.drawable.yellowfishselected :imageID=R.drawable.yellowfishselectedsleeps;break;


                case R.drawable.mine: imageID=R.drawable.minesleeps;break;
                case R.drawable.mineselected: imageID=R.drawable.mineselectedsleeps;break;


                default: break;
            }
        }
        else{
            switch (imageID){
                case R.drawable.bluefishsleeps:imageID=R.drawable.bluefish;break;
                case R.drawable.bluefishselectedsleeps: imageID=R.drawable.bluefishselected;break;

                case R.drawable.purplefishsleeps:imageID=R.drawable.purplefish;break;
                case R.drawable.purplefishselectedsleeps:imageID=R.drawable.purplefishselected;break;

                case R.drawable.redfishsleeps :imageID=R.drawable.redfish;break;
                case R.drawable.redfishselectedsleeps: imageID=R.drawable.redfishselected;break;

                case R.drawable.yellowfishsleeps :imageID=R.drawable.yellowfish;break;
                case R.drawable.yellowfishselectedsleeps:imageID=R.drawable.yellowfishselected;break;


                case R.drawable.minesleeps: imageID=R.drawable.mine;break;
                case R.drawable.mineselectedsleeps: imageID=R.drawable.mineselected;break;


                default: break;
            }
        }


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
