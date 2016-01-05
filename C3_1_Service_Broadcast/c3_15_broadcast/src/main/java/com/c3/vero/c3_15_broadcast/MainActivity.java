package com.c3.vero.c3_15_broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button send;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent=new Intent();
        send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setAction("vero.vero.broadcast");
                intent.putExtra("e",1111);
                sendBroadcast(intent);
                sendOrderedBroadcast(intent,null);
                //指定权限
//                sendOrderedBroadcast(intent,"vero.vero.vero");

            }
        });

    }

}
