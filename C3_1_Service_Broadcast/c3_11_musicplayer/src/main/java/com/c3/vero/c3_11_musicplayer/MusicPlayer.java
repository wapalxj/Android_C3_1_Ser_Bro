package com.c3.vero.c3_11_musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by vero on 2015/11/20.
 */
public class MusicPlayer extends AppCompatActivity implements View.OnClickListener{
    private Button start;
    private Button pause;
    private Button stop;
    private Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        start=(Button)findViewById(R.id.start);
        pause=(Button)findViewById(R.id.pause);
        stop=(Button)findViewById(R.id.stop);
        intent =new Intent(MusicPlayer.this,MusicPlayerService.class);
        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int vId =v.getId();
        switch (vId){
            case R.id.start:
                intent.putExtra("conmand",1);
                startService(intent);
                break;
            case R.id.pause:
                intent.putExtra("conmand", 2);
                startService(intent);
                break;
            case R.id.stop:
                intent.putExtra("conmand",3);
                startService(intent);
                break;
            default:
                break;
        }
    }




}
