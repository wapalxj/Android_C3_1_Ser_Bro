package com.c3.vero.c3_service_broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int arr2[][] = {{4,3},{2,1}};

        for(int x[]: arr2){
            for (int i=0;i<1;i++){
                Toast.makeText(getApplicationContext(),""+ x[i],Toast.LENGTH_SHORT).show();
            }
//            Toast.makeText(getApplicationContext(),""+ x.length,Toast.LENGTH_SHORT).show();
        }
    }

}
