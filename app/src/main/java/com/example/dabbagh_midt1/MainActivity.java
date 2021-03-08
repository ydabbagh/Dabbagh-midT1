package com.example.dabbagh_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = new MediaPlayer();
        player = MediaPlayer.create(this, R.raw.track1);
        playing = 0;
        Button btn2 = (Button) findViewById(R.id.buttonActivity1toActivity2);
        Button btn3 = (Button) findViewById(R.id.buttonActivity1toActivity3);
        ImageView giraffe = (ImageView) findViewById(R.id.imageView);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity3.class));
            }
        });

        giraffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        player.start();
                        playing=1;
                        break;
                    case 1:
                        player.pause();
                        playing=0;
                        break;
                }
            }
        });
    }
}