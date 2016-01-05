package com.c3.vero.c3_11_musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MusicPlayerService extends Service {
    private int mId;
    private MediaPlayer mediaPlayer;
    public MusicPlayerService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        Log.i("MusicPlayerService", "onCreate");
        mediaPlayer=MediaPlayer.create(getApplicationContext(), R.raw.music);
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int  startId){
        Log.i("MusicPlayerService", "onStartCommand");
        mId=startId;
        int conmmand=intent.getExtras().getInt("conmand");
        switch (conmmand){
            case 1:
//                Toast.makeText(MusicPlayerService.this,""+conmmand,Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
                break;
            case 2:
                mediaPlayer.pause();
                break;
            case 3:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=null;
                break;
            default:
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("MusicPlayerService","onDestroyonDestroyonDestroy");
        super.onDestroy();
    }


}
