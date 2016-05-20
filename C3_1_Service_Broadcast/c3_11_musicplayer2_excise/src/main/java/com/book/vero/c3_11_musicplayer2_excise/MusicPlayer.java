package com.book.vero.c3_11_musicplayer2_excise;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by vero on 2016/1/6.
 */
public class MusicPlayer extends Service{
    private MediaPlayer player;
    private int totalTime;
    private int currentTime;
    private SeekChangeReceiver receiver;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(getApplicationContext(),R.raw.aaa);
        IntentFilter filter=new IntentFilter(Config.seekChange);
        receiver=new SeekChangeReceiver();
        registerReceiver(receiver,filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int flag=intent.getExtras().getInt(Config.musicState);
        switch (flag){
            case 1:
                if (player.isPlaying()){
//                    player.pause();
                    Intent iPause =new Intent(Config.musicIsPause);
                    iPause.putExtra("isPause", "isPause");
                    sendBroadcast(iPause);
                }else{
                    player.start();
                    final Intent iPlaying =new Intent(Config.musicIsPlaying);
                    iPlaying.putExtra("isPlaying","isPlaying");

                    totalTime=player.getDuration();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (player.isPlaying()){
                                currentTime=player.getCurrentPosition();
                                iPlaying.putExtra("totalTime", totalTime);
                                iPlaying.putExtra("currentTime", currentTime);
                                sendBroadcast(iPlaying);
                            }
                        }
                    }).start();

                }

                break;


            case 2:
                player.stop();
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent IsStop =new Intent(Config.musicIsStop);
                IsStop.putExtra("isStop","isStop");
                sendBroadcast(IsStop);
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        player=null;
        unregisterReceiver(receiver);
    }

    //progress change
    class SeekChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Config.seekChange)){
                int progress=intent.getExtras().getInt(Config.seekChangeState);
                player.seekTo(progress);
            }
        }
    }


}
