package com.truiton.activitytofragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by apple1 on 06/08/16.
 */

public class SecondActivity extends AppCompatActivity implements IFragmentToActivity  {


    private TextView txtVw_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.second_layout);
        txtVw_msg=(TextView)findViewById(R.id.txtVw_msg);

    }
    @Override
    public void showToast(String msg) {
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        txtVw_msg.setText("MSG from Fragment:"+msg);
        txtVw_msg.setTextColor(Color.parseColor("#FF57FC7E"));
    }

    @Override
    public void communicateToFragment2() {


    }
}
