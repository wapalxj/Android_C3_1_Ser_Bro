package com.c3.vero.c3_9_test_nrebind;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {
    //实现接口对象
    private IBinder mBinder =new MyBinder();
    public BoundService() {
    }
    //定义Binder接口实现
    public class MyBinder extends Binder{
        public BoundService getService(){
            return BoundService.this;
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
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("vvvvvvvvv","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }


}
