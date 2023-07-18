package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicDemo extends Service  implements MediaPlayer.OnCompletionListener{

    MediaPlayer mp;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp=MediaPlayer.create(this,R.raw.chutia);
        mp.setOnCompletionListener(this);
    }

    @Override
    public void onDestroy() {
        if(mp.isPlaying()){
            mp.stop();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(!mp.isPlaying()){
            mp.start();
        }
        return START_STICKY;
    }


}
