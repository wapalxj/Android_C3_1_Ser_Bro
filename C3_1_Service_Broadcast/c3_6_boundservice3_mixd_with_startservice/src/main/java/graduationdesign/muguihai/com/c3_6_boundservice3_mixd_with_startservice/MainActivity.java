package graduationdesign.muguihai.com.c3_6_boundservice3_mixd_with_startservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private IService mService;
    private ServiceConnection conn;

    private Button start,bind,unbind,exe,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        conn=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService= (IService) service;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService=null;
            }
        };

        intent=new Intent(getApplicationContext(),MyService.class);
        start= (Button) findViewById(R.id.start);
        bind= (Button) findViewById(R.id.bind);
        unbind= (Button) findViewById(R.id.unbind);
        exe= (Button) findViewById(R.id.exe);
        stop= (Button) findViewById(R.id.stop);

        onclicks(start,bind,unbind,exe,stop);
    }

    public void onclicks(Button... btns){
        for (Button temp:btns){
            temp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.start:
                            startService(intent);
                            break;
                        case R.id.bind:
                            bindService(intent,conn,BIND_AUTO_CREATE);
                            break;
                        case R.id.unbind:
                            unbindService(conn);
                            break;
                        case R.id.exe:
                            mService.getService();
                            break;
                        case R.id.stop:
                            stopService(intent);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
    }
}
