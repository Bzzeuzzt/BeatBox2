package com.example.el_mohandes.beatbox2;

public class Sound {

    private String mAssetPath;
    private String mAssetName;
    private Integer mSoundID;


    Sound(String mAseetPath) {
        this.mAssetPath= mAseetPath;
        String[] Components = mAseetPath.split("/");
        mAssetName = Components[Components.length - 1];
    }

    String getmAseetPath() {
        return mAssetPath;
    }

     String getmAssetName() {
        return mAssetName;
    }

     void setmAssetName(String mAssetName) {
        this.mAssetName = mAssetName;
    }

     Integer getmSoundID() {
        return mSoundID;
    }

     void setmSoundID(Integer mSoundID) {
        this.mSoundID = mSoundID;
    }

}
