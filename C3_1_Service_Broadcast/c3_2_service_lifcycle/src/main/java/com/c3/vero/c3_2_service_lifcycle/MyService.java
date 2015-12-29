package com.c3.vero.c3_2_service_lifcycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private int mId;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onCreate() {
        Log.i("veroSSSSSSSS","onCreate");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int  startId){
        Log.i("veroSSSSSSSS","onStartCommand");
        mId=startId;
//        helloService();//耗时操作会阻塞界面
        //耗时操作应该开启新线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                helloService();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("veroSSSSSSSS","onDestroyonDestroyonDestroy");
        super.onDestroy();
    }


    private void helloService(){
//        for (int i=0;i<2;i++){//这行不开启新线程的实验：读取完毕后阻塞界面恢复
        for (int i=0;i<20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("veroSSSSSSSS",i+"");
        }
    }

}
