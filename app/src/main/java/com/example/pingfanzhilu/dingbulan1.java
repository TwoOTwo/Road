package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by 杨~ on 2015/10/5.
 */
public class dingbulan1 extends LinearLayout {
    public dingbulan1(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.personalreturnactivity, this);
        ImageButton titleBack = (ImageButton) findViewById(R.id.ibu10);

//        titleBack.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent  = new Intent(getContext(),zhuce.class);
//
//
////                        ((Activity) getContext()).finish();
//    }   });

    }
}
