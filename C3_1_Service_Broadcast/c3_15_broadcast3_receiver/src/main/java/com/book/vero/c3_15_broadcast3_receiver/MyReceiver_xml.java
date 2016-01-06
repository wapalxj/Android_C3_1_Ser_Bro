package com.book.vero.c3_15_broadcast3_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 接收sender发送过来的广播
 * Created by vero on 2016/1/6.
 */
public class MyReceiver_xml extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Config.sendAction)){
            int count=intent.getIntExtra("count",-1);
            Toast.makeText(context,"另外一个APP的xml_receiver:"+count,Toast.LENGTH_SHORT).show();
        }
        if (intent.getAction().equals(Config.sendAction_au)){
            String au_broadcast= intent.getStringExtra("au_broadcast");
            Toast.makeText(context,"MyReceiver_xml接收到带权限的广播:"+au_broadcast,Toast.LENGTH_LONG).show();
        }
    }
}
