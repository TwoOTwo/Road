package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import DB.User;
import DB.WelfareDB;


public class denglu extends Activity {
    private WelfareDB welfareDB;
    private EditText editText1;
    private EditText editText2;
    private List<User> userList;
    private Button button;

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
               if(userList.size()>0)
               {
                   String account1= editText1.getText().toString();
                   String password1 = editText2.getText().toString();
                   for (User user : userList)
                   {

                       if (account1.equals(user.getAccount()) && password1.equals(user.getPassword()))
                       {

                           Intent intent13 = new Intent(denglu.this, gerenzhongxin.class);
                           startActivity(intent13);
                      }

                    }

                }
            }
        });



    }
}
