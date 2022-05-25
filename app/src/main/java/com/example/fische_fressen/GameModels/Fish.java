package com.example.fische_fressen.GameModels;

import android.graphics.Color;

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

    int imageID;
    int size;
    String ID;
    Color color;
    boolean isEmpty;
    enum fishType{

    }
}
