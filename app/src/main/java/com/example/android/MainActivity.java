package com.example.android;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button nwuser;
    Button login;
    EditText eid;
    TextView tevi;
    String URL = "https://cosc-team-14-restapi.herokuapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eid = (EditText) findViewById(R.id.empid);
        tevi = (TextView) findViewById(R.id.textView9);
        nwuser = (Button) findViewById(R.id.newuser);
        nwuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newuser();
            }
        });
        login = (Button) findViewById(R.id.login);

    }
    public void newuser(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void login(){

            Intent intent = new Intent(this, firstpg.class);
            startActivity(intent);
    }
}
