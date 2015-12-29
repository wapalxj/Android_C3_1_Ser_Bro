package com.c3.vero.c3_15_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Toast.makeText(context, "ssssssssssssssssssssss" , Toast.LENGTH_SHORT).show();
            Log.i("onReceive","ssssssssmmmmmmmmmmmmmmmmmmm");
            //终止广播
//            abortBroadcast();
        }
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
