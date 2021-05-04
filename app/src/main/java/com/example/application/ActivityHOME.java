package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityHOME extends AppCompatActivity {

    private ImageView play6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e);

        this.play6 = (ImageView) findViewById(R.id.play6);

        play6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Activity1.class );
                startActivity(otherActivity);
                finish();
            }
        });
    }
}