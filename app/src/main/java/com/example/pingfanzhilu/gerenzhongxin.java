package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 杨~ on 2015/10/15.
 */
public class gerenzhongxin extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenzhongxinactivity);
        Button denglu = (Button) findViewById(R.id.button);
        Button zhuce = (Button)findViewById(R.id.button2);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(gerenzhongxin.this,denglu.class);
                startActivity(intent12);
            }
        });


        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent13 = new Intent(gerenzhongxin.this,denglu.class);
                startActivity(intent13);
            }
        });
    }

}
