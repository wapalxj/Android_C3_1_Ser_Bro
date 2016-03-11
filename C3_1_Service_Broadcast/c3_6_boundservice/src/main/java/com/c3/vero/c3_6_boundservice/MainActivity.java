package com.c3.vero.c3_6_boundservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private ServiceConnection conn;
    MyBoundService myS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("vvvvvvvvv", "onServiceConnected"+name);
                myS=((MyBoundService.MyBinder)service).getService();
                Toast.makeText(MainActivity.this,myS.helloworld("vvvvvv"),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("vvvvvvvvv", "onServiceDisconnected");
            }
        };
        Button bind=(Button)findViewById(R.id.bind);
        final Button unbind=(Button)findViewById(R.id.unbind);
        Button startA=(Button)findViewById(R.id.startActivity);

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent = new Intent(MainActivity.this, MyBoundService.class);
                intent=new Intent("com.vnix.MyBoundService");
                intent.setPackage("com.c3.vero.c3_6_boundservice");
                bindService(intent, conn, Service.BIND_AUTO_CREATE);

            }
        });

        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
        startA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startA = new Intent(MainActivity.this, Client2.class);
                startActivity(startA);
            }
        });
    }


    @Override
    protected void onStop() {
//        unbindService(conn);
        super.onStop();
    }

}
