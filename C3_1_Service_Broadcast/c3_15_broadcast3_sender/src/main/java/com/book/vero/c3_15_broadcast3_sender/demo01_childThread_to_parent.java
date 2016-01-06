package com.book.vero.c3_15_broadcast3_sender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * thread---->main
 * 子线程发送到主线程
 */
public class demo01_childThread_to_parent extends AppCompatActivity {
    private Button sender;
    private TextView receiverTv;

    private Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        IntentFilter filter=new IntentFilter();
        filter.addAction(Config.sendAction);
        registerReceiver(new MyReceiver(), filter);
    }
    public void init(){
        receiverTv= (TextView) findViewById(R.id.receiverTv);
        sender= (Button) findViewById(R.id.send);
        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });

        start= (Button) findViewById(R.id.strat);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Demo02_Authority_Bro_sender.class);
                startActivity(intent);
            }
        });
    }

    public void send(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                Intent intent=new Intent(Config.sendAction);
                while (count<=10){
                    intent.putExtra("count",count++);
                    sendBroadcast(intent);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    class MyReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Config.sendAction)){
                int count=intent.getIntExtra("count",-1);
                receiverTv.setText(String.valueOf(count));
            }
        }
    }
}
