package com.example.sajidmacpro.arraylistbundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sajidMacPro on 3/1/16.
 */
public class AndroidSecondActivity extends AppCompatActivity {
    public TextView showData;
    public String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showData=(TextView)findViewById(R.id.showData);

        Intent in = getIntent();

        Bundle b = in.getExtras();
        ArrayList<String> arrayList=(ArrayList<String>)b.getStringArrayList("key");

        for(int i=0;i<arrayList.size();i++){
             data+=arrayList.get(i);
        }
        showData.setText(data);

    }


}
