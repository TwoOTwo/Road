package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by 杨~ on 2015/10/29.
 */
public class wangqitupian extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wangqitupianactivity);
        ImageButton wq1 = (ImageButton)findViewById(R.id.wqtp1);
        ImageButton wq2 = (ImageButton)findViewById(R.id.wqtp2);
        ImageButton wq3 = (ImageButton)findViewById(R.id.wqtp3);
        ImageButton wq4 = (ImageButton)findViewById(R.id.wqtp4);
        wq1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent50 = new Intent(wangqitupian.this, com.example.pingfanzhilu.wqtp1.class);
                startActivity(intent50);
            }
        });
        wq2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent51 = new Intent(wangqitupian.this, com.example.pingfanzhilu.wqtp2.class);
                startActivity(intent51);
            }
        });
        wq3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent52 = new Intent(wangqitupian.this, com.example.pingfanzhilu.wqtp3.class);
                startActivity(intent52);
            }
        });
        wq4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent53 = new Intent(wangqitupian.this, com.example.pingfanzhilu.wqtp4.class);
                startActivity(intent53);
            }
        });
    }
    }

