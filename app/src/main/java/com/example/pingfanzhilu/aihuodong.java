package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;

import DB.Event;
import DB.HttpCallbackListener;
import DB.HttpUtil;
import DB.Utility;
import DB.WelfareDB;

/**
 * Created by 杨~ on 2015/10/14.
 */
public class aihuodong extends Activity
{

    private  ProgressDialog progressDialog;
    private TextView thing1;
    private TextView thing2;
    private TextView thing3;
   // private ArrayAdapter<String> adapter;
    private WelfareDB welfareDB;
    private  List<String> dataList = new ArrayList<String>();
    private List<Event> eventList;
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aihuodongactivity);
        thing1 = (TextView)findViewById(R.id.thing1);
        thing2 = (TextView)findViewById(R.id.thing2);
        thing3 = (TextView)findViewById(R.id.thing3);
      //  adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        welfareDB = WelfareDB.getInstance(this);
        queryEvent();
    }
    private void queryEvent()
    {
        eventList = welfareDB.loadEvent();
        if (eventList.size()>0)
        {
            for (Event event :eventList)
            {
                thing1.setText(event.getThing());

            }
        }
    }
    //从服务器端访问数据
    private void queryFromServer(final String code,final String type)
    {
      String address;
        if (!TextUtils.isEmpty(code))
        {
            address = "http://10.0.2.2:8080/kankong/index.html";
        }
        else
        {
            address = "http://10.0.2.2:8080/kankong/index.html";
        }
        showProgressDialog();
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                boolean result = false;
                result = Utility.handleWelfareResponse(welfareDB,response);
                if (result)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialog();
                            queryEvent();
                        }
                    });
                }
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }


    public void onError(Exception e)
    {
// 通过runOnUiThread()方法回到主线程处理逻辑
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                closeProgressDialog();
                Toast.makeText(aihuodong.this,
                        "加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }






    /**
     * 显示进度对话框
     */
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    private void closeProgressDialog()
    {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
