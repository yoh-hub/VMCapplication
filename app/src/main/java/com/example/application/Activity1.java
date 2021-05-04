package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity1 extends AppCompatActivity {

    private ImageView play1;
    private ImageView play2;
    private ImageView play3;
    private ImageView play8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        this.play1 = (ImageView) findViewById(R.id.play1);

        play1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ActivityMet.class );
                startActivity(otherActivity);
                finish();
            }
        });
        this.play2 = (ImageView) findViewById(R.id.play2);

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),ActivityVMC.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.play3 = (ImageView) findViewById(R.id.play3);

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),ActivityHOME.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.play8 = (ImageView) findViewById(R.id.play8);

        play8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}