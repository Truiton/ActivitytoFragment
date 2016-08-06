package com.truiton.activitytofragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.utils.MyApplication;

/**
 * Created by apple1 on 06/08/16.
 */

public class SecondActivity extends AppCompatActivity implements IFragmentToActivity  {
/*This is the Link to achieve  Values from fragments into activity*/
    /*http://stackoverflow.com/questions/4878159/whats-the-best-way-to-share-data-between-activities*/
    private TextView txtVw_msg;
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        txtVw_msg=(TextView)findViewById(R.id.txtVw_msg);

        app = (MyApplication) getApplicationContext();
        String data = app.getData();
        txtVw_msg.setText(data);
        txtVw_msg.setTextColor(Color.parseColor("#FF57FC7E"));

    }
    @Override
    public void showToast(String msg) {
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void communicateToFragment2() {


    }
}
