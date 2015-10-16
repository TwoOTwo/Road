package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import DB.CreateTable;
import DB.User;
import DB.WelfareDB;

/**
 * Created by 杨~ on 2015/10/15.
 */
public class denglu extends Activity {
    private WelfareDB welfareDB;
    private EditText editText1;
    private EditText editText2;
    private List<User> userList;
    private Button button;
    boolean b =false;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dengluactivity);
        editText1 = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        button = (Button)findViewById(R.id.button);
        welfareDB = WelfareDB.getInstance(this);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userList = WelfareDB.loadUser();
                if(userList.size()>0) {
                    for (User user : userList) {
                        if (user.getAccount().equals(editText1.getText()) && user.getUsername().equals(editText2.getText())) {
                            Intent intent13 = new Intent(denglu.this, gerenzhongxin.class);
                            startActivity(intent13);
                        } else {
                            Toast.makeText(denglu.this, "账号或密码错误",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });



    }
}
