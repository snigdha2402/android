package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    Button register;
    EditText empid,empname,deptno,desg,email,contact,address,pass,noleaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        empid=(EditText) findViewById(R.id.empno);
        empname=(EditText) findViewById(R.id.empname);
        deptno=(EditText) findViewById(R.id.deptno);
        desg=(EditText) findViewById(R.id.desg);
        email=(EditText) findViewById(R.id.email);
        contact=(EditText) findViewById(R.id.phno);
        address=(EditText) findViewById(R.id.address);
        pass=(EditText) findViewById(R.id.password);
        noleaves=(EditText) findViewById(R.id.leaves);
        register=(Button) findViewById(R.id.register);


    }
}
