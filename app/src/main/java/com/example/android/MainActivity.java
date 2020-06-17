package com.example.android;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button nwuser;
    Button login;
    EditText eid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nwuser = (Button) findViewById(R.id.newuser);
        nwuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newuser();
            }
        });
     /*   login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });*/
    }
    public void newuser(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
  /*  public void login(){
        Intent intent = new Intent(this,firstpg.class);
        startActivity(intent);
    } */
}
