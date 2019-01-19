package com.example.el_mohandes.beatbox2;

public class Sound {

    String mAssetPath;
    String mAssetName;

    public Sound(String mAseetPath) {
        this.mAssetPath= mAseetPath;
        String[] Components = mAseetPath.split("/");
        mAssetName = Components[Components.length - 1];
    }

    public String getmAseetPath() {
        return mAssetPath;
    }

    public String getmAssetName() {
        return mAssetName;
    }

    public void setmAssetName(String mAssetName) {
        this.mAssetName = mAssetName;
    }
}
