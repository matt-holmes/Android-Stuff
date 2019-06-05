package io.matt.sounddemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    MediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMediaPlayer = MediaPlayer.create(this, R.raw.barking );
    }

    public void buttonControls(View view) {
        if(view.getId() == R.id.playButton) {
            myMediaPlayer.start();
        } else {
            myMediaPlayer.pause();
        }
    }


}
