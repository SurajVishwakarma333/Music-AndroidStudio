package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    //for playing the music
    public void Play(View view){
        mediaPlayer.start();
    }
    //for Pausing the music
    public void Pause(View view){
        mediaPlayer.pause();
    }
    //for Stopping the music
    public void Stop(View view){
        mediaPlayer.stop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.ncs);
    }
}

/*how to add music.mp3 in android studio
  steps:-
        1. res->new->Android Resource Directory
        give any file_name .,but Resource type should be selected as a raw.
        it will generate new file as a row in res folder.
        2.copy and paste the music.mp3 in raw file. remember that name of video should contain lowercase only.
        3. Adding 3 button play , pause and stop
        4. giving onClick on all 3 button
   */