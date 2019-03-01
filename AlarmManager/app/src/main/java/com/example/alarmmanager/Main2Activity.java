package com.example.alarmmanager;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mediaPlayer = MediaPlayer.create(this,R.raw.alarm);
        mediaPlayer.start();
        Toast.makeText(this,"Alarm...",Toast.LENGTH_LONG).show();
    }
}
