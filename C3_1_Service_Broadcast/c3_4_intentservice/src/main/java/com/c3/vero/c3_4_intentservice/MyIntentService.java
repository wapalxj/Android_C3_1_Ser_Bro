package com.c3.vero.c3_4_intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        Log.i("vvvvvvvv","onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i("vvvvvvvv","onDestroy");
        super.onDestroy();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("vvvvvvvv","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
//        return  START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i("vvvvvvvv","onHandleIntent");
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i("MyIntentService",i+"");
        }
    }


}
