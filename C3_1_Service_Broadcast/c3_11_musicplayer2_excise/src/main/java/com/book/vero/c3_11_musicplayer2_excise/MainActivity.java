package com.book.vero.c3_11_musicplayer2_excise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play;
    private Button stop;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    @Override
    public void onClick(View v) {
        boolean isPlaying=false;
        intent=new Intent(getApplicationContext(),MusicPlayer.class);
        switch (v.getId()){
            case R.id.btn_play:
                intent.putExtra("play",1);
                startService(intent);
                break;
            case R.id.btn_stop:
                intent.putExtra("play",2);
                startService(intent);
                break;
        }
    }
    public void init(){
        play= (Button) findViewById(R.id.btn_play);
        stop= (Button) findViewById(R.id.btn_stop);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);

    }


}
