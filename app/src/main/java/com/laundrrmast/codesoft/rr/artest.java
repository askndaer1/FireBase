package com.laundrrmast.codesoft.rr;

/**
 * Created by CodeSoft on 7/4/2017.
 */

public class artest {
    String artestID;
    String artestName;

    public String getArtestID() {
        return artestID;
    }

    public void setArtestID(String artestID) {
        this.artestID = artestID;
    }

    public String getArtestName() {
        return artestName;
    }

    public void setArtestName(String artestName) {
        this.artestName = artestName;
    }

    public String getArtestG() {
        return artestG;
    }

    public void setArtestG(String artestG) {
        this.artestG = artestG;
    }

    String artestG;

    public artest(String artestID, String artestName, String artestG) {
        this.artestID = artestID;
        this.artestName = artestName;
        this.artestG = artestG;
    }

    public artest(){}

}
