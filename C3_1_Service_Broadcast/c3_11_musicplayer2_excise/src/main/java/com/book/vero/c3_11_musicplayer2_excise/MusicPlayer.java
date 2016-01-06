package com.book.vero.c3_11_musicplayer2_excise;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by vero on 2016/1/6.
 */
public class MusicPlayer extends Service{
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(getApplicationContext(),R.raw.aaa);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int flag=intent.getExtras().getInt("play");
        switch (flag){
            case 1:
                player.start();
                break;
            case 2:
                player.stop();
                break;
        }
        return 0;
//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player=null;
    }


}
