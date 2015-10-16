package com.example.pingfanzhilu;

import android.app.Activity;
import android.os.Bundle;


import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import DB.Event;
import DB.HttpCallbackListener;
import DB.HttpUtil;
import DB.Utility;
import DB.WelfareDB;

/**
 * Created by 杨~ on 2015/10/14.
 */
public class aihuodong extends Activity {
    public static final int LEVEL_PROVINCE = 0;
    private ProgressDialog progressDialog;
    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String>adapter;
    private WelfareDB welfareDB;
    private List<String> dataList = new ArrayList<String>();

    //事件列表
    private List<Event> eventList;
    //选中事件
    private Event selectedEvent;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.aihuodongactivity);
        listView = (ListView)findViewById(R.id.list_view);
        textView = (TextView)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);
        welfareDB = WelfareDB.getInstance(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                selectedEvent = eventList.get(position);
                queryEvent();
            }
        });

    }

    private void queryEvent()
    {
        eventList = welfareDB.loadEvent();
        if(eventList.size() >0)
        {
            dataList.clear();
            for (Event event:eventList)
            {
                dataList.add(event.getThing());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            textView.setText("公益事件");

        }
        else{
            queryFromServer(selectedEvent.getThing(),"event");
        }
    }

    //根据传入的代号和类型从服务上查询事件数据。
    private void queryFromServer(final String code,final String type) {
        String address;
        if (!TextUtils.isEmpty(code)) {
            address = "http://www.weather.com.cn/data/list3/city" + code + ".xml";
        } else {
            address = "http://www.weather.com.cn/data/list3/city.xml";
        }
        showProgressDialog();
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                boolean result = false;
                result = Utility.handleWelfareResponse(welfareDB,response);
                if(result)
                {
                    // 通过runOnUiThread()方法回到主线程处理逻辑
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
            public void onError(Exception e)
            {
                // 通过runOnUiThread()方法回到主线程处理逻辑
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(aihuodong.this,"加载失败",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    /**
     * 显示进度对话框
     }  */
    private void showProgressDialog()
    {
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
    private void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }


}
