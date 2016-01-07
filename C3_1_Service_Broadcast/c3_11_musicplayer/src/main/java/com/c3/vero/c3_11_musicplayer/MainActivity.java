package com.c3.vero.c3_11_musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mediaPlayer;
    private Button start;
    private Button pause;
    private Button stop;
    private Button startActivityService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.aaa);
        start=(Button)findViewById(R.id.start);
        pause=(Button)findViewById(R.id.pause);
        stop=(Button)findViewById(R.id.stop);
        startActivityService=(Button)findViewById(R.id.startServiceActivity);

        start.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        startActivityService.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int vId =v.getId();
        switch (vId){
            case R.id.start:
                mediaPlayer.start();
                break;
            case R.id.pause:
                mediaPlayer.pause();
                break;
            case R.id.stop:
                mediaPlayer.stop();
                break;
            case R.id.startServiceActivity:
                Intent intent =new Intent(MainActivity.this,MusicPlayer.class);
                startActivity(intent);
                break;
        }
    }


}
