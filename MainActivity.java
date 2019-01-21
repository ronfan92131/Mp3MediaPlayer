package com.example.mp3mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View v){
        if (player == null){
            player = MediaPlayer.create(this, R.raw.c192);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    //stopPlayer();  //one time play or test
                    player.start();  // releatitive play, personal usage, running cadence
                }
            });
        }
        player.start();
    }

    public void pause(View v){
        if (player!= null){
            player.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if (player!=null){
            player.release();
            player= null;
            Toast.makeText(this, "Mediaplayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
