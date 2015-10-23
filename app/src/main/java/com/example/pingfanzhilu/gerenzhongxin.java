package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import model.User;
import db.PublicWelfareDB;

/**
 * Created by 杨~ on 2015/10/15.
 */
public class gerenzhongxin extends Activity {
    private PublicWelfareDB welfareDB;
    private User user;

   // private List<User> userList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenzhongxinactivity);
        Button denglu = (Button) findViewById(R.id.button);
        Button zhuce = (Button)findViewById(R.id.button2);
       welfareDB = PublicWelfareDB.getInstance(this);
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(gerenzhongxin.this, com.example.pingfanzhilu.denglu.class);
                startActivity(intent12);
            }
        });


        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //user.setId(1);
                user = new User();
                user.setAccount("1234");
                user.setPassword("1234");
                          // userList.add(user);
                          welfareDB.saveUser(user);
                //Intent intent13 = new Intent(gerenzhongxin.this,denglu.class);
               // startActivity(intent13);
            }
        });
    }

}
