package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ActivityVMC extends AppCompatActivity {

    private ImageView play5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_m_c);

        this.play5 = (ImageView) findViewById(R.id.play5);

        play5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Activity1.class );
                startActivity(otherActivity);
                finish();
            }
        });
    }
}

