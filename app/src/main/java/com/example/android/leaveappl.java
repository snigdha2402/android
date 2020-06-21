package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    String emplid,titl,stadt,enddt,nodays,reason,emerg;
    String key_empid="EMPID",key_titl="LEAVETITLE",key_sta="STDATE",key_end="ENDDATE",
            key_days="NOOFDAYS",key_rea="REASON",key_emg="EMGLEAVE";
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
        emplid=empid.getText().toString();
        titl=title.getText().toString();
        reason=reas.getText().toString();
        stadt=stdate.getText().toString();
        enddt=endate.getText().toString();
        nodays=days.getText().toString();
        emerg=emg.getText().toString();

        JSONObject data = new JSONObject();
        data.put(key_empid,emplid);
        data.put(key_titl,titl);
        data.put(key_rea,reason);
        data.put(key_sta,stadt);
        data.put(key_end,enddt);
        data.put(key_days,nodays);
        data.put(key_emg,emerg);

        queue= Volley.newRequestQueue(this);
        objectRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast toast = Toast.makeText(getApplicationContext(),"leave applied!",Toast.LENGTH_LONG);
                        toast.show();
                    }
                },
                new Response.ErrorListener(){
                  @Override
                    public void onErrorResponse(VolleyError error){
                      Toast toast = Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG);
                      toast.show();
                  }
                });

    }
}
