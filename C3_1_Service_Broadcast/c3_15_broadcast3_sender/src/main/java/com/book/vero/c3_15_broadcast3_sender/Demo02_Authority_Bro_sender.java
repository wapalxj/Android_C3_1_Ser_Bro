package com.book.vero.c3_15_broadcast3_sender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Demo02_Authority_Bro_sender extends AppCompatActivity {

    private Button sender_auBro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo02__authority__bro_sender);
        sender_auBro= (Button) findViewById(R.id.send);
        sender_auBro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Config.sendAction_au);
                intent.putExtra("au_broadcast","这个是一个带sendAction_au权限的广播");
                sendBroadcast(intent, Config.authority);//权限
            }
        });
    }

}
