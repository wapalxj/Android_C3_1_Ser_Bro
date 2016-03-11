package com.example.administrator.c3_15_broadcast2_receive_system3_sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("smsssssssssssssssssss", "SMS is receiving!");

        /**
         * www.grepcode.com  ---搜寻 android.provider.Telephony.SMS_RECEIVED  --- 找到 Telephony 类 , 有如下的方法, 这是现成 的
         告诉我们如何去解析 获得一个短消息
         */
        Object[] objs = (Object[]) intent.getExtras().get("pdus");

        for (Object obj : objs) {

            SmsMessage message = SmsMessage.createFromPdu((byte[]) obj);

            // message 就是一个短消息 实体数据

            String messageBody = message.getMessageBody();
            //发送者  ...
            String sender = message.getOriginatingAddress();

            if("1387655".equals(sender)){
                abortBroadcast();
            }
            Log.i("111111","messageBody 短信内容 : " + messageBody);
            Log.i("222222","sender  发送人  : " + sender);
        }
    }

}
