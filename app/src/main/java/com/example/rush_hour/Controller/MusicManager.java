package com.example.rush_hour.Controller;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.rush_hour.R;

public class MusicManager {

    //Attributes
    private Context context;
    private MediaPlayer mediaPlayer;

    /**
     * Constructor which set up the media with a default music
     * @param context The context of the activity
     */
    public MusicManager(Context context){
        this.context = context;
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.music_fond);
        mediaPlayer.setLooping(true);
    }

    /**
     * Method which set up the music manager with klaxon
     */
    public void playKlaxon(){
        mediaPlayer = MediaPlayer.create(context.getApplicationContext(), R.raw.klaxon);
        mediaPlayer.setLooping(false);
    }

    /**
     * Method which starts the media
     */
    public void start(){
        mediaPlayer.start();
    }

    /**
     * Method which pauses the media
     */
    public void pause(){
        mediaPlayer.pause();
    }

    /**
     * Method which stops the media
     */
    public void stop(){
        mediaPlayer.stop();
    }

}
