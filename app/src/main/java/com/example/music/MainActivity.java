package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
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

        mediaPlayer = MediaPlayer.create(this,R.raw.ncs);  //adding music.

        //for adjusting volume.
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maximumVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar seekBar =findViewById(R.id.seekBar);

        seekBar.setMax(maximumVol);
        seekBar.setProgress(currentVol);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //for adjusting song forward backward seekbar

          final SeekBar progressBar = findViewById(R.id.progressBar);
           progressBar.setMax(mediaPlayer.getDuration());

           new Timer().scheduleAtFixedRate(new TimerTask() {
               @Override
               public void run() {
                   progressBar.setProgress(mediaPlayer.getCurrentPosition());
               }
           },0,10000);

           progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
               @Override
               public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                   mediaPlayer.seekTo(i);
               }

               @Override
               public void onStartTrackingTouch(SeekBar seekBar) {

               }

               @Override
               public void onStopTrackingTouch(SeekBar seekBar) {

               }
           });
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