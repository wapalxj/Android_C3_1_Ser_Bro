package com.book.vero.c3_6_boundservice2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private IBinder mBinder=new MyBinder();
    public MyService() {
    }

    public class MyBinder extends Binder implements IService{

        @Override
        public MyService getService() {
            say();
            return MyService.this;
        }
        public void say(){
            Log.i("MyBinder","MyBinder的say()");
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("onBind","onBind()");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("onUnbind","onUnbind()");
        return super.onUnbind(intent);
    }
}
