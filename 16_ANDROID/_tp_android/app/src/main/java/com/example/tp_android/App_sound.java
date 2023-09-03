package com.example.tp_android;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class App_sound extends AppCompatActivity {
    private Button btnBlack;
    private Button btnGreen;
    private Button btnRed;
    private Button btnYellow;
    private Button btnPurple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appsound_layout);

        btnBlack = findViewById(R.id.btnBlack);
        btnGreen = findViewById(R.id.btnGreen);
        btnRed = findViewById(R.id.btnRed);
        btnYellow = findViewById(R.id.btnYellow);
        btnPurple = findViewById(R.id.btnPurple);

        MediaPlayer mpBlack = MediaPlayer.create(this, R.raw.black);
        MediaPlayer mpGreen = MediaPlayer.create(this, R.raw.green);
        MediaPlayer mpRed = MediaPlayer.create(this, R.raw.red);
        MediaPlayer mpYellow = MediaPlayer.create(this, R.raw.yellow);
        MediaPlayer mpPurple = MediaPlayer.create(this, R.raw.purple);

        for (int i = 0; i < 5; i++) {
            btnBlack.setOnClickListener((e) -> {
                mpBlack.start();
            });
            btnGreen.setOnClickListener((e) -> {
                mpGreen.start();
            });
            btnRed.setOnClickListener((e) -> {
                mpRed.start();
            });
            btnYellow.setOnClickListener((e) -> {
                mpYellow.start();
            });
            btnPurple.setOnClickListener((e) -> {
                mpPurple.start();
            });
        }
    }
}
