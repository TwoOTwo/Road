package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 杨~ on 2015/10/5.
 */
public class dingbulan extends LinearLayout {
    public dingbulan(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.returnactivity, this);
        ImageButton titleBack = (ImageButton) findViewById(R.id.ibu10);

        titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
    }   });

    }
}
