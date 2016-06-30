package com.adhyapak.skypeforbusiness;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mSkypeId;
    Button m1;
    Button m2;
    Button m3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSkypeId = (EditText)findViewById(R.id.skypeId);
        m1 = (Button)findViewById(R.id.m1);
        m2 = (Button)findViewById(R.id.m2);
        m3 = (Button)findViewById(R.id.m3);
        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String skypeId = mSkypeId.getText().toString();
        if(!TextUtils.isEmpty(skypeId)) {
            if (id == m1.getId()) {
                Toast.makeText(MainActivity.this, "Method 1", Toast.LENGTH_SHORT).show();
                method1(skypeId);
            } else if (id == m2.getId()) {
                Toast.makeText(MainActivity.this, "Method 2", Toast.LENGTH_SHORT).show();
                method2(skypeId);

            } else if (id == m3.getId()) {
                Toast.makeText(MainActivity.this, "Method 3", Toast.LENGTH_SHORT).show();
                method3(skypeId);

            }
        }else {
            Toast.makeText(MainActivity.this, "Enter Skype Id", Toast.LENGTH_SHORT).show();
        }
    }

    private void method3(String skypeId) {
        Intent sky = new Intent("android.intent.action.VIEW");
        sky.setData(Uri.parse("Callto:sip:"+ skypeId));
        if(sky.resolveActivity(getPackageManager()) != null) {
            startActivity(sky);
        }else {
            Toast.makeText(MainActivity.this, "No Activity to handle", Toast.LENGTH_SHORT).show();
        }
    }

    private void method2(String skypeId) {
        Intent sky = new Intent("android.intent.action.VIEW");
        sky.setData(Uri.parse("sip://"+ skypeId+"?call"));
        if(sky.resolveActivity(getPackageManager()) != null) {
            startActivity(sky);
        }else {
            Toast.makeText(MainActivity.this, "No Activity to handle", Toast.LENGTH_SHORT).show();
        }
    }

    private void method1(String skypeId) {
        Intent sky = new Intent("android.intent.action.VIEW");
        sky.setData(Uri.parse("lync://"+ skypeId+"?call"));
        if(sky.resolveActivity(getPackageManager()) != null) {
            startActivity(sky);
        }else {
            Toast.makeText(MainActivity.this, "No Activity to handle", Toast.LENGTH_SHORT).show();
        }
    }
}
