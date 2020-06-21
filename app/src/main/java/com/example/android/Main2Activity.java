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
    String key_empid="EMPID";
    String key_pass="PASS";
    String key_ename="EMPNAME",key_dpt="DEPTNO",key_pno="CONTACT",key_email="EMAIL",key_addr="ADDRESS",key_lev="NOLEAVES",
           key_desg="DESG";

    String emp_id;
    String passwrd,ename,dpt,pno,email,addr,lev,desg;
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
        emp_id=empid.getText().toString();
        ename=empname.getText().toString();
        dpt=deptno.getText().toString();
        desg=desig.getText().toString();
        email=emailid.getText().toString();
        pno=contact.getText().toString();
        addr=address.getText().toString();
        passwrd=pass.getText().toString();
        lev=noleaves.getText().toString();
        data = new JSONObject();
        data.put(key_empid,emp_id);
        data.put(key_ename,ename);
        data.put(key_dpt,dpt);
        data.put(key_desg,desg);
        data.put(key_email,email);
        data.put(key_pno,pno);
        data.put(key_addr,addr);
        data.put(key_pass,passwrd);
        data.put(key_lev,lev);

        queue= Volley.newRequestQueue(this);
        objectRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast toast = Toast.makeText(getApplicationContext(),"registration successful!",Toast.LENGTH_LONG);
                        toast.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(getApplicationContext(),"ERROR!!",Toast.LENGTH_LONG);
                        toast.show();
                    }
                });


    }
}
