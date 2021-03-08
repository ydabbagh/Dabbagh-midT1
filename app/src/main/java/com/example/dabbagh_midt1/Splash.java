package com.example.dabbagh_midt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
    TextView countdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countdown= (TextView) findViewById(R.id.txtCountDown);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash.this, MainActivity.class));
            }
        };

        Timer opening = new Timer();
        opening.schedule(task,6000);
    }
    CountDownTimer s = new CountDownTimer(6000, 1000) {
        public void onTick(long millisUntilFinished) {
            countdown.setText("Seconds remaining: " + millisUntilFinished / 1000);
        }
        public void onFinish() {
            countdown.setText("Welcome!");
        }
    }.start();

}