package com.example.uno.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSet = (Button)findViewById(R.id.btnSetAlarm);
        etVal = (EditText)findViewById(R.id.etVal);

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int time = Integer.parseInt(etVal.getText().toString());
                Intent intent=new Intent(MainActivity.this, Alarm.class);
                PendingIntent p1=PendingIntent.getBroadcast(getApplicationContext(),0, intent,0);
                AlarmManager a=(AlarmManager)getSystemService(ALARM_SERVICE);
                a.set(AlarmManager.RTC,System.currentTimeMillis() + time*1000,p1);

            }
        });
    }
}
