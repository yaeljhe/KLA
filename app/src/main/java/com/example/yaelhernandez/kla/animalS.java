package com.example.yaelhernandez.kla;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

public class animalS extends AppCompatActivity {

    private Button homeAN;
    private Button cowBtn;
    private Button birdBtn;
    private Button roosterBtn;


    private SoundPool soundPool;
    private SparseIntArray soundMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_s);

        homeAN = (Button) findViewById(R.id.homeAN);
        homeAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(animalS.this,R.anim.rotate);
                homeAN.startAnimation(animation);
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                goHome();
                            }
                        }, 650
                );
            }
        });



        configureSounds();
        initializeSoundBtn();

    }

    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void configureSounds() {
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        soundMap = new SparseIntArray(3);
        soundMap.put(1, soundPool.load(this, R.raw.cow, 1));
        soundMap.put(2, soundPool.load(this, R.raw.bird, 1));
        soundMap.put(3, soundPool.load(this, R.raw.rooster, 1));


        }

    private void initializeSoundBtn() {

        cowBtn = findViewById(R.id.cowbtn);
        birdBtn =  findViewById(R.id.birdbtn);
        roosterBtn =  findViewById(R.id.roosterbtn);


        cowBtn.setOnClickListener(playSound);
        birdBtn.setOnClickListener(playSound);
        roosterBtn.setOnClickListener(playSound);

    }

    private View.OnClickListener playSound = new View.OnClickListener() {
        public void onClick(View btn) {

            // IDENTIFY THE SOUND TO BE PLAYED
            String soundName = (String) btn.getContentDescription();

            // PLAY THE SOUND
            if (soundName.contentEquals("COW")) {
                soundPool.play(1, 1, 1, 1, 0, 1.0f);
            }
            else if (soundName.contentEquals("BIRD")) {
                soundPool.play(2, 1, 1, 1, 0, 1.0f);
            }
            else if (soundName.contentEquals("ROOSTER"))
                soundPool.play(3, 1, 1, 1, 0, 1.0f);

        }
    };

}

