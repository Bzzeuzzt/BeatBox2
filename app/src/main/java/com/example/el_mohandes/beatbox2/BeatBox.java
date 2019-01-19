package com.example.el_mohandes.beatbox2;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {


    ArrayList<Sound> mSounds;
    AssetManager mAssets;

    public BeatBox(Context context) {
        mSounds = new ArrayList<>();
        mAssets = context.getAssets();
        try {
            String[] filenames = mAssets.list("sample_sounds");
            for (String filename: filenames ) {
                String path = "sample_sounds"+"/"+filename;
                Sound sound = new Sound(path);
                mSounds.add(sound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Sound> getSounds(){
        return mSounds;
    }
}
