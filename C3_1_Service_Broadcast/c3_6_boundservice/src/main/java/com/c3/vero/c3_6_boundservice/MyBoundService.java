package com.c3.vero.c3_6_boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyBoundService extends Service {
    //实现接口对象
    private IBinder mBinder =new MyBinder();
    public MyBoundService() {
    }
    //定义Binder接口实现
    public class MyBinder extends Binder{
        public MyBoundService getService(){
            return MyBoundService.this;
        }

    }
    public String helloworld(String name){
        return "you name:"+name;
    }
    @Override
    public void onDestroy() {
        Log.i("vvvvvvvvv","onDestroy");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Log.i("vvvvvvvvv","onCreate");
        super.onCreate();
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("vvvvvvvvv","onBind");
        return mBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("vvvvvvvvv","onUnbind111111111111111");
//        return super.onUnbind(intent);
        return true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("vvvvvvvvv","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("vvvvvvvvv","onRebindrrrrrrrrrrrrrrrrrrrr");
        super.onRebind(intent);
    }
}
