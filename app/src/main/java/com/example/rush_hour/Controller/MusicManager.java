package com.example.rush_hour.Controller;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.rush_hour.R;

public class MusicManager {

    //Attributes
    private Context context;
    private MediaPlayer mediaPlayer;

    //Constructor //Default music
    public MusicManager(Context context){
        this.context = context;
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.music_fond);
        mediaPlayer.setLooping(true);
    }

    public void playKlaxon(){
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.klaxon);
        mediaPlayer.setLooping(false);
    }

    public void start(){
        mediaPlayer.start();
    }

    public void pause(){
        mediaPlayer.pause();
    }

    public void stop(){
        mediaPlayer.stop();
    }

}
