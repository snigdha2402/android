package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    Button register;
    EditText empid,empname,deptno,desig,emailid,contact,address,pass,noleaves;

    RequestQueue queue;
    JsonObjectRequest objectRequest;
    JSONObject data;
    String URL = "https://cosc-team-14-restapi.herokuapp.com/emp_register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        empid=(EditText) findViewById(R.id.empno);
        empname=(EditText) findViewById(R.id.empname);
        deptno=(EditText) findViewById(R.id.deptno);
        desig=(EditText) findViewById(R.id.desg);
        emailid=(EditText) findViewById(R.id.email);
        contact=(EditText) findViewById(R.id.phno);
        address=(EditText) findViewById(R.id.address);
        pass=(EditText) findViewById(R.id.password);
        noleaves=(EditText) findViewById(R.id.leaves);
        register=(Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    userregister();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                queue.add(objectRequest);
                backtologin();
            }
        });
    }

    public void backtologin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void userregister() throws JSONException {

        data = new JSONObject();
        data.put("EMPID",empid.getText().toString());
        data.put("EMPNAME",empname.getText().toString());
        data.put("DEPTNO",deptno.getText().toString());
        data.put("DESG",desig.getText().toString());
        data.put("EMAIL",emailid.getText().toString());
        data.put("CONTACT",contact.getText().toString());
        data.put("ADDRESS",address.getText().toString());
        data.put("PASS",pass.getText().toString());
        data.put("NOLEAVES",noleaves.getText().toString());

        queue= Volley.newRequestQueue(this);
        objectRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                data,
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
                });


    }
}
