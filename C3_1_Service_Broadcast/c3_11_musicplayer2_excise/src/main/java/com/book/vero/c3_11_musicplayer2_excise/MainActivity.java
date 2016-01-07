package com.book.vero.c3_11_musicplayer2_excise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button play;
    private Button stop;
    private SeekBar seekBar;
    private TextView timeTv;
    private TextView totalTimeTv;
    Intent intent;
    private BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    @Override
    public void onClick(View v) {
        intent=new Intent(getApplicationContext(),MusicPlayer.class);
        switch (v.getId()){
            case R.id.btn_play:
                intent.putExtra(Config.musicState, 1);
                startService(intent);

                break;
            case R.id.btn_stop:
                intent.putExtra(Config.musicState, 2);
                startService(intent);
                break;
        }
    }
    public void init(){
        play= (Button) findViewById(R.id.btn_play);
        stop= (Button) findViewById(R.id.btn_stop);
        seekBar = (SeekBar) findViewById(R.id.progress);
        seekBar.setEnabled(true);
        timeTv= (TextView) findViewById(R.id.timeTv);
        totalTimeTv= (TextView) findViewById(R.id.totalTimeTv);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                    Intent seekChange=new Intent(Config.seekChange);
                    seekChange.putExtra(Config.seekChangeState,seekBar.getProgress());
                    sendBroadcast(seekChange);
            }
        });

        //广播接收:更改时间显示和进度条
        receiver=new MusicBroadcast();
        IntentFilter filter=new IntentFilter();
        filter.addAction(Config.musicIsPlaying);
        filter.addAction(Config.musicIsPause);
        filter.addAction(Config.musicIsStop);

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    class MusicBroadcast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String state=intent.getAction();
            if (state.equals(Config.musicIsPause)||state.equals(Config.musicIsStop)){
                play.setText("开始");
            }
            if (state.equals(Config.musicIsPlaying)){
                play.setText("暂停");
                //set time show
                int totalTime=intent.getExtras().getInt("totalTime");
                int currentTime=intent.getExtras().getInt("currentTime");
                seekBar.setMax(totalTime);
                seekBar.setProgress(currentTime);
                totalTimeTv.setText(transferTime(totalTime));
                timeTv.setText(transferTime(currentTime));
            }
            if (state.equals(Config.musicIsStop)){
                play.setText("开始");
                seekBar.setProgress(0);
            }
        }
    }
    //transfer time to xx:xx
    public String transferTime(int time){
        String timeString=new String ("");
        int temp=time/1000;
        if (temp<10){
            timeString="00:0"+temp;
        }else if (temp>=10&&temp<60){
            timeString="00:"+temp;
        }else if (temp>=60&&temp<600){
            int temp2=temp/60;
            int temp3=temp-temp2*60;
            if (temp3<10){
                timeString="0"+temp2+":0"+temp3;
            }else {
                timeString="0"+temp2+":"+temp3;
            }

        }
        return timeString;
    }

}
