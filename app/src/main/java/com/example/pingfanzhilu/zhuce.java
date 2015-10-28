package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import db.PublicWelfareDB;
import model.User;


public class zhuce extends Activity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private Button button;
    private PublicWelfareDB welfareDB;
    private User user;
    private static final String TAG = "Socket_Android";

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
                user.setPhotoaddress("shili");

                Socket socket = null;
                try
                {
                    InetAddress serverAddr = InetAddress.getByName("192.168.1.100");
                    // TCPServer.SERVERIP
                    Log.d("TCP", "C: Connecting...");
                    // 应用Server的IP和端口建立Socket对象
                    socket = new Socket(serverAddr, 51706);

//                   Log.d("TCP", "C: Sending: '" + message + "'");

                    // 将信息通过这个对象来发送给Server
                    PrintWriter out = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),
                            true);

                    // 把用户输入的内容发送给server

                  String toServer = editText1.getText().toString()+editText2.getText().toString()+editText3.getText().toString();
                    Log.d(TAG, "To server:'" + toServer + "'");
//                   out.println(toServer);
                    out.flush();

                    // 接收服务器信息
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    // 得到服务器信息
                    String msg = in.readLine();
                   Log.d(TAG, "From server:'" + msg + "'");
                    Toast.makeText(zhuce.this,msg,Toast.LENGTH_SHORT).show();
//                   // 在页面上进行显示
//                   tx1.setText(msg);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }finally {
                    try {
                        socket.close();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }

                welfareDB.saveUser(user);
                Intent intent13 = new Intent(zhuce.this,gerenzhongxin.class);
                intent13.putExtra("user_data", user);
                startActivity(intent13);
//                Toast.makeText(zhuce.this,"注册成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
