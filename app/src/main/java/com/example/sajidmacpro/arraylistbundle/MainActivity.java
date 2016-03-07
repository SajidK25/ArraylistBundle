package com.example.sajidmacpro.arraylistbundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText name,phone_no,age;
    CheckBox married;
    String fullname,phoneNumber,ageBirth;
    boolean isMarried=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeEditTexts();
        Button send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromForm();
                ArrayList<String> stringArrayList=new ArrayList<String>();
                stringArrayList.add(fullname);
                stringArrayList.add(phoneNumber);
                stringArrayList.add(ageBirth);
                stringArrayList.add(String.valueOf(isMarried));

                Bundle b=new Bundle();
                b.putStringArrayList("key",stringArrayList);
                Intent in=new Intent(MainActivity.this,AndroidSecondActivity.class);
                in.putExtras(b);
                startActivity(in);
            }
        });
    }
    public void initializeEditTexts() {
        name = (EditText) findViewById(R.id.name);
        phone_no = (EditText) findViewById(R.id.phone_no);
        age = (EditText) findViewById(R.id.age);
        married = (CheckBox) findViewById(R.id.married);
    }

    public void getDataFromForm() {
        fullname = name.getText().toString();
        phoneNumber = phone_no.getText().toString();
        ageBirth = age.getText().toString();
        isMarried = married.isChecked();
    }
}
