package com.example.android;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    JsonObjectRequest objectRequest;
    JSONObject j;
    TextView nwuser;
    Button login;
    EditText eid,pass;
    String empid;
    String passwrd;
    String URL = "https://cosc-team-14-restapi.herokuapp.com/emp_login";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eid = (EditText) findViewById(R.id.empid);
        pass=(EditText) findViewById(R.id.password);
        nwuser = (TextView) findViewById(R.id.newuser);
        nwuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newuser();
            }
        });
        login = (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {
                    login();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                queue.add(objectRequest);
            }
        });


    }
    public void newuser(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
    public void login() throws JSONException {
       //  Intent intent = new Intent(this, firstpg.class);
       //  startActivity(intent);
        j = new JSONObject();
            j.put("EMPID", eid.getText().toString());
            j.put("PASS", pass.getText().toString());

        queue = Volley.newRequestQueue(this);


        objectRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                j,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("rest response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("rest response", error.toString());
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                String creds = String.format("%s:%s", "username", "password");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }
        };

    }
}
