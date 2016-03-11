package com.book.vero.c3_6_boundservice2;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private IService mService;
    private ServiceConnection conn;

    private Button bind,unbind,exe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=new Intent(getApplicationContext(),MyService.class);
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService=(IService)service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService=null;
            }
        };

        init();
    }

    public void init(){
        bind= (Button) findViewById(R.id.bind);
        unbind= (Button) findViewById(R.id.unbind);
        exe= (Button) findViewById(R.id.exe);

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent,conn,BIND_AUTO_CREATE);
            }
        });
        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
                conn=null;
            }
        });
        exe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mService.getService();
            }
        });
    }

}
