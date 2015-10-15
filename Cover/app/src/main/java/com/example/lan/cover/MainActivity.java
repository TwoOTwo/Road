package com.example.lan.cover;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.lan.cover.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView1;

    ImageButton button1,search1,a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cover_main);

        imageView1 = (ImageView) findViewById(R.id.imageView);
        //imageView1.setOnClickListener(this);
       // button1 = (ImageButton) findViewById(R.id.btn2);
        //search1 = (ImageButton) findViewById(R.id.btn3);

        imageView1.setOnClickListener(this);
       // button1 = (ImageButton) findViewById(R.id.btn2);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        if (R.id.imageView == v.getId()) {
         Intent intent = new Intent();
            intent.setClass(MainActivity.this,Home.class);
         startActivity(intent);


        }
    }
        /**
         else {
            if (R.id.imageButton3 == v.getId()) {
//         Intent intent = new Intent(this,MainActivity.class);
//         startActivity(intent);
                setContentView(R.layout.search);

            } else if (R.id.imageButton4 == v.getId()) {
//         Intent intent = new Intent(this,MainActivity.class);
//         startActivity(intent);
                setContentView(R.layout.lookfor);


            }
        }***/


    }

