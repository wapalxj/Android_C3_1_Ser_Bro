package com.book.vero.c3_15_broadcast2_receive_system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
/**
用真机调试
 */
public class MainActivity extends AppCompatActivity {
    private TextView screenTv;
    private TextView batteryTv;
    private TextView powerTv;
    private TextView netTv;
    private TextView headSetTv;
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        IntentFilter filter=new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        receiver=new MyReceiver();
        registerReceiver(receiver,filter);
    }

    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case Intent.ACTION_SCREEN_OFF:
                        screenTv.setText("屏幕刚才被关闭了");
                    break;
                case Intent.ACTION_BATTERY_CHANGED:
                            int b=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                            batteryTv.setText(b+"%");
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                        powerTv.setText("电源断开了");
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                        powerTv.setText("电源连接了");
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    if(intent.getIntExtra("state",0)==1){
                        headSetTv.setText("耳机插入了！");
                    }
                    if(intent.getIntExtra("state",0)==0){
                        headSetTv.setText("耳机拔出了！");
                    }

                    break;
                case "android.net.conn.CONNECTIVITY_CHANGE":
                    String re="网络连接:";

                    //方式1
//                    boolean no_Net=intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);//false
//                    int type=intent.getIntExtra(ConnectivityManager.EXTRA_NETWORK_TYPE, 0);
//
//                    if (type==ConnectivityManager.TYPE_MOBILE){
//                        re+=" type:MOBILE,";
//                    }else if (type==ConnectivityManager.TYPE_WIFI){
//                        re+=" type:WIFI,";
//                    }
//                    if (no_Net){
//                        re+=" 状态：no";
//                    }else if (!no_Net){
//                        re+=" 状态：yes";
//                    }


                    //方式2,(推荐)
                    ConnectivityManager manager= (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo info=manager.getActiveNetworkInfo();
                    if (info!=null){

                        if (info.getType()==ConnectivityManager.TYPE_MOBILE&&info.isAvailable()){
                            re+="type:mobile,状态：yes";
                        }
                        if (info.getType()==ConnectivityManager.TYPE_WIFI&&info.isAvailable()){
                            re+="type:WIFI,状态：yes";
                        }
                    }
                    else {
                        re+="没有网络";
                    }
                    netTv.setText(re);
                    break;
            }
        }
    }

    public void init(){
        screenTv= (TextView) findViewById(R.id.screenTv);
        batteryTv= (TextView) findViewById(R.id.batteryTv);
        powerTv= (TextView) findViewById(R.id.powerTv);
        netTv= (TextView) findViewById(R.id.netTv);
        headSetTv=(TextView)findViewById(R.id.headSetTv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);

    }
}
