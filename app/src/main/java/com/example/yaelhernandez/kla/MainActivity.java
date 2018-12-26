package com.example.yaelhernandez.kla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button animalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //IMPLEMENTS ANIMATION TO ANIMAL BUTTON
        animalBtn = (Button) findViewById(R.id.soundsbtn);
        animalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                animalBtn.startAnimation(animation);

                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                openAnimalS();
                            }
                        }, 700
                );
            }
        });

    }


    //IMPLEMENTS INTENT TO ANIMAL SOUNDS ACTIVITY
    public void openAnimalS(){
        Intent intent = new Intent(this,animalS.class);
        startActivity(intent);
    }


}
