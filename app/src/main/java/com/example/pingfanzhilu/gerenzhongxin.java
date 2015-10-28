package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import model.User;

/**
 * Created by 杨~ on 2015/10/15.
 */
public class gerenzhongxin extends Activity {
//    private PublicWelfareDB welfareDB;
    private User user;
    private Button denglu;
    private Button zhuce;
   // private List<User> userList;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenzhongxinactivity);
        denglu = (Button) findViewById(R.id.button);
        zhuce = (Button)findViewById(R.id.button2);
        TextView jifen = (TextView)findViewById(R.id.jifen);
        TextView time = (TextView)findViewById(R.id.time);
        ImageView photo =(ImageView)findViewById(R.id.photo);
        user = new User();
        user = (User)getIntent().getSerializableExtra("user_data");

        if(user!=null) {

             denglu.setVisibility(View.INVISIBLE);
             zhuce.setVisibility(View.INVISIBLE);

            jifen.setText(String.valueOf(user.getIntegral()));
            time.setText(String.valueOf(user.getThelength()));
//            String p = user.getPhotoaddress();
            photo.setImageResource(R.drawable.shili);
        }

//       welfareDB = PublicWelfareDB.getInstance(this);
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
//                user = new User();
//                user.setAccount("1234");
//                user.setPassword("1234");
//                          // userList.add(user);
//                          welfareDB.saveUser(user);
                Intent intent13 = new Intent(gerenzhongxin.this, com.example.pingfanzhilu.zhuce.class);
                startActivity(intent13);
            }
        });

        ImageButton titleBack = (ImageButton) findViewById(R.id.ibu10);
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gerenzhongxin.this,MainActivity.class);

//                intent.putExtra("user_data", user);
                startActivity(intent);
            }
        });
    }

}
