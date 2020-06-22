package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

public class leaveappl extends AppCompatActivity {

    Button apply;
    EditText empid,title,stdate,endate,days,reas;
    CheckBox emg;

    RequestQueue queue;
    JsonObjectRequest objectRequest;
    String URL="https://cosc-team-14-restapi.herokuapp.com/empleave";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaveappl);
        apply=(Button) findViewById(R.id.apply);
        title=(EditText) findViewById(R.id.title);
        stdate=(EditText) findViewById(R.id.stdate);
        endate=(EditText) findViewById(R.id.endate);
        days=(EditText) findViewById(R.id.days);
        reas=(EditText) findViewById(R.id.reason);
        empid=(EditText) findViewById(R.id.empid);
        emg=(CheckBox) findViewById(R.id.emglev);

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    applyleave();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public void applyleave() throws JSONException {


        JSONObject data = new JSONObject();
        data.put("EMPID",empid.getText().toString());
        data.put("LEAVETITLE",title.getText().toString());
        data.put("REASON",reas.getText().toString());
        data.put("STDATE",stdate.getText().toString());
        data.put("ENDDATE",endate.getText().toString());
        data.put("NOOFDAYS",days.getText().toString());
        data.put("EMGLEAVE",emg.getText().toString());

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
                new Response.ErrorListener(){
                  @Override
                    public void onErrorResponse(VolleyError error){
                      Log.e("rest response", error.toString());
                  }
                });

    }
}
