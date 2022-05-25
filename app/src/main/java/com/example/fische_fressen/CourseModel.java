package com.example.fische_fressen;

public class CourseModel {

    // string course_name for storing course_name
    // and imgid for storing image id.

    private int imgid;

    public CourseModel( int imgid) {

        this.imgid = imgid;
    }


    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}