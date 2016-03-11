package com.example.administrator.c3_15_broadcast2_receive_system2_ipdialer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText prefix_Tv;
    private Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        prefix_Tv=(EditText)findViewById(R.id.editText);
        save=(Button)findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prefix = prefix_Tv.getText().toString().trim();
                if(TextUtils.isEmpty(prefix)){
                    Toast.makeText(getApplicationContext(), "ip 拨号前缀不能为空 ...", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sp = getSharedPreferences("config", 0);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("prefix", prefix);
                edit.commit();
                Toast.makeText(getApplicationContext(), "ip 拨号前缀  保存 成功 ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
