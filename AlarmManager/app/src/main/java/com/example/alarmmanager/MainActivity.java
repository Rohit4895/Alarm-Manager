package com.example.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button start, stop;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.insetInput);
        start = findViewById(R.id.startAlarm);
        stop = findViewById(R.id.stopAlarm);

        Intent intent = new Intent(this,Main2Activity.class);
        pendingIntent = PendingIntent.getActivity(MainActivity.this,1,intent,0);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAlert();
            }
        });
    }

    public void startAlert(){
        /*int i = Integer.parseInt(editText.getText().toString());*/



        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES,pendingIntent);
        Toast.makeText(getApplicationContext(),"Alarm  has Set",Toast.LENGTH_LONG).show();
    }

    public void stopAlert(){
        if (alarmManager != null)
        alarmManager.cancel(pendingIntent);
    }
}
