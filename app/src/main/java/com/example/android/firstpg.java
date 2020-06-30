package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class firstpg extends AppCompatActivity {
    Button nwlev,levhis,prof;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpg);
        nwlev = (Button) findViewById(R.id.button2);
        levhis = (Button) findViewById(R.id.button);
        prof = (Button) findViewById(R.id.button3);
        nwlev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newleave();
            }
        });
        levhis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leavehistory();
            }
        });
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profilepg();
            }
        });
    }
    public void newleave(){
        Intent intent = new Intent(this, leaveappl.class);
        startActivity(intent);
    }
    public void leavehistory(){
        Intent intent = new Intent(this, levhistory.class);
        startActivity(intent);
    }
    public void profilepg(){
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}
