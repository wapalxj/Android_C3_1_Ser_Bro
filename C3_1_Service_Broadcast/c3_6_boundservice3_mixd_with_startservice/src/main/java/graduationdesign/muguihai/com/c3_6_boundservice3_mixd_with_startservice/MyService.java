package graduationdesign.muguihai.com.c3_6_boundservice3_mixd_with_startservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.net.BindException;

public class MyService extends Service {
    private MyBinder mBinder=new MyBinder();
    public MyService() {
    }

    class MyBinder extends Binder implements IService{
        @Override
        public MyService getService() {
            say();
            return MyService.this;
        }

        public void say(){
            Log.i("say","say");
        }
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("onCreate", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("onStartCommand", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("onBind","onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("onUnbind","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy","onDestroy");
    }
}
