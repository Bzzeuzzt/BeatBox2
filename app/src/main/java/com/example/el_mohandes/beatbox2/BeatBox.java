package com.example.el_mohandes.beatbox2;

import android.content.Context;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 class BeatBox {


    private ArrayList<Sound> mSounds;
     private AssetManager mAssets;
     private SoundPool soundPool;

     BeatBox(Context context) {
        mSounds = new ArrayList<>();
        mAssets = context.getAssets();
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        try {
            String[] filenames = mAssets.list("sample_sounds");
            for (String filename: filenames ) {
                String path = "sample_sounds"+"/"+filename;
                Sound sound = new Sound(path);
                loadSound(sound);
                mSounds.add(sound);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     ArrayList<Sound> getSounds(){
        return mSounds;
    }

    void loadSound(Sound sound) throws IOException {

            sound.setmSoundID(soundPool.load(mAssets.openFd(sound.getmAseetPath()),1));

    }

    void playSound(Sound sound){
        Integer soundID = sound.getmSoundID();
        if(soundID==null){
            return;
        }
        soundPool.play(soundID,1,1,1,0,1);

    }

    void release(){
        soundPool.release();
    }
}
