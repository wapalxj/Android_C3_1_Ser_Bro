package com.book.vero.c3_7_aidl_client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.book.vero.c3_7_aidl_service.IService;

public class MainActivity extends AppCompatActivity {
    private IService mService;
    private MyConn conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conn=new MyConn();
    }

    public void bindService(View v){
        Intent i=new Intent();
        i.setAction("com.vero.remoteService");
        i.setPackage("com.book.vero.c3_7_aidl_service");
        bindService(i,conn, Context.BIND_AUTO_CREATE);
    }
    public void useMethod(View v){
        try {
            mService.callInRemoteService();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    class MyConn implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService=IService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}

