package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class firstpg extends AppCompatActivity {
    Button nwlev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpg);
        nwlev = (Button) findViewById(R.id.button2);
        nwlev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newleave();
            }
        });
    }
    public void newleave(){
        Intent intent = new Intent(this, leaveappl.class);
        startActivity(intent);
    }
}
