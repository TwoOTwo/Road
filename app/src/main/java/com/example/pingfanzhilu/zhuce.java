package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.PublicWelfareDB;
import model.User;


public class zhuce extends Activity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private PublicWelfareDB welfareDB;
    private User user;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuceactivity);

        editText1 = (EditText)findViewById(R.id.account);
        editText2 = (EditText)findViewById(R.id.password);
        editText3 = (EditText)findViewById(R.id.phonenumber);
        button = (Button)findViewById(R.id.regest);

        welfareDB = PublicWelfareDB.getInstance(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User();
                user.setAccount(editText1.getText().toString());
                user.setPassword(editText2.getText().toString());
                user.setPhonenumber(editText3.getText().toString());
                user.setIntegral(0);
                user.setThelength(0);
                user.setWelfareid(0);

                welfareDB.saveUser(user);
                Intent intent13 = new Intent(zhuce.this,gerenzhongxin.class);
                intent13.putExtra("user_data", user);
                startActivity(intent13);
//                Toast.makeText(zhuce.this,"注册成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
