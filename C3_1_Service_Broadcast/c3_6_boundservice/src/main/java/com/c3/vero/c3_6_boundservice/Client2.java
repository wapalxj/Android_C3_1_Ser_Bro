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

public class Client2 extends AppCompatActivity {
    private Intent intent;
    private ServiceConnection conn;
    MyBoundService myS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client2);
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("vvvvvvvvv", "onServiceConnected" + name.toString());
                myS=((MyBoundService.MyBinder)service).getService();
                Toast.makeText(Client2.this, myS.helloworld("vvvvvv"), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("vvvvvvvvv", "onServiceDisconnected");
            }
        };
        Button bind2=(Button)findViewById(R.id.bind2);
        Button unbind2=(Button)findViewById(R.id.unbind2);

        bind2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Client2.this, MyBoundService.class);
                bindService(intent,conn, Service.BIND_AUTO_CREATE);
            }
        });

        unbind2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });
    }



}
