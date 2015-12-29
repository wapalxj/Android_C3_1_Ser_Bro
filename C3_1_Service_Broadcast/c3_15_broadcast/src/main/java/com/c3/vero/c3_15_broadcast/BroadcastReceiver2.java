package com.c3.vero.c3_15_broadcast;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by vero on 2015/11/20.
 */
public class BroadcastReceiver2 extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!=null) {
            Toast.makeText(context, "" + intent.getExtras().getInt("e")+222, Toast.LENGTH_SHORT).show();
            //终止广播
//            abortBroadcast();
        }
    }
}