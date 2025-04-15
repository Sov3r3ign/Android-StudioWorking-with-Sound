package com.example.practical6;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button kaijuSongButton, lacrimosaSongButton;

    MediaPlayer mpKaiju, mpLacrimosa;
    int playing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaijuSongButton = (Button) findViewById(R.id.btnkaiju);
        lacrimosaSongButton = (Button) findViewById(R.id.btnlacrimosa);

        kaijuSongButton.setOnClickListener(bKaiju);
        lacrimosaSongButton.setOnClickListener(bLacrimosa);

        mpKaiju = new MediaPlayer();
        mpKaiju = MediaPlayer.create(this, R.raw.youngbludkaiju);

        mpLacrimosa = new MediaPlayer();
        mpLacrimosa = MediaPlayer.create(this, R.raw.mozartlacrimosa);

        playing = 0;
    }
    Button.OnClickListener bKaiju = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            switch (playing)
            {
                case 0:
                    mpKaiju.start();
                     playing = 1;
                     kaijuSongButton.setText("Pause Kaiju");
                     lacrimosaSongButton.setVisibility(View.INVISIBLE);
                break;
                case 1:
                    mpKaiju.pause();
                    playing = 0;
                    kaijuSongButton.setText("Play Kaiju");
                    lacrimosaSongButton.setVisibility(View.VISIBLE);
                break;
            }
        }
    };
    Button.OnClickListener bLacrimosa = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v) {

            switch (playing)
            {
                case 0:
                    mpLacrimosa.start();
                    playing = 1;
                    lacrimosaSongButton.setText("Pause Lacrimosa");
                    kaijuSongButton.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpLacrimosa.pause();
                    playing = 0;
                    lacrimosaSongButton.setText("Play Lacrimosa");
                    kaijuSongButton.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}