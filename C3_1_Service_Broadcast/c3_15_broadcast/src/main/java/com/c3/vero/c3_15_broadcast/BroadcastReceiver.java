package com.c3.vero.c3_15_broadcast;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent!=null) {
            Toast.makeText(context, "" + intent.getExtras().getInt("e"), Toast.LENGTH_SHORT).show();
        }
    }
}
