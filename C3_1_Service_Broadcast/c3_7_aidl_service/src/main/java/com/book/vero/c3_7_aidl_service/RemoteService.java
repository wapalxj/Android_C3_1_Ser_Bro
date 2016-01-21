package com.book.vero.c3_7_aidl_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service{
    private class Agent extends IService.Stub{

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void callInRemoteService() throws RemoteException {
            RemoteMethod();
        }
    }


    public RemoteService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        Log.i("iiiiiiiiii","远程服务被创建和绑定");

        return new Agent();
    }

    @Override
    public void onDestroy() {
        Log.i("iiiiiiiiii","远程服务被销毁");
        super.onDestroy();

    }

    public void RemoteMethod(){
        Log.i("iiiiiiiiii","远程服务方法被调用");
    }

}
