package com.truiton.activitytofragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;
import com.utils.IFragmentToActivity;
import com.utils.MyApplication;

/**
 * Created by apple1 on 06/08/16.
 */

public class SecondActivity extends AppCompatActivity implements IFragmentToActivity {
/*This is the Link to achieve  Values from fragments into activity*/
    /*http://stackoverflow.com/questions/4878159/whats-the-best-way-to-share-data-between-activities*/
    private TextView txtVw_msg;
    MyApplication app;
    private ImageView imgVw_youtube_thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);
        txtVw_msg=(TextView)findViewById(R.id.txtVw_msg);

        app = (MyApplication) getApplicationContext();
        String data = app.getData();
        String img_url = app.getData();
        txtVw_msg.setText(data);
        txtVw_msg.setTextSize(20);
        txtVw_msg.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);

        //txtVw_msg.setTextColor(Color.parseColor("#FF57FC7E"));
        imgVw_youtube_thumbnail=(ImageView)findViewById(R.id.imgVw_youtube_thumbnail);
        //Glide.with(this).load(img_url).centerCrop().placeholder(R.drawable.iphone_7_img_2).diskCacheStrategy(DiskCacheStrategy.ALL).into(imgVw_youtube_thumbnail);
        Picasso.with(this).load(img_url).fit().centerCrop().placeholder(R.drawable.iphone_7_img_2).into(imgVw_youtube_thumbnail);
    }
    @Override
    public void showToast(String msg) {
        //Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void communicateToFragment2() {


    }
}
