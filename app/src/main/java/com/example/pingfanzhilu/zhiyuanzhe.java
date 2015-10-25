package com.example.pingfanzhilu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;


public class zhiyuanzhe extends Activity {
    private Context context;
    private ListView listView;
    private ArrayList<Appinfos> appInfos;
    private AppAdapter appAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhiyuanzheactivity);
        getComponenets();
    }

    /**
     * componenet
     */
    public void getComponenets(){
        this.context = this;
        listView = (ListView) findViewById(R.id.listView2);
        appInfos = new ArrayList<Appinfos>();
        loadDatas();
        appAdapter = new AppAdapter(context,appInfos);
        listView.setAdapter(appAdapter);
    }


    public void loadDatas(){
        for (int i = 1; i < 10; i++) {
            Appinfos ai = new Appinfos();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 5){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 7){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 8){
                ai.setImages(R.drawable.zhuye1);
            }else if(i == 9){
                ai.setImages(R.drawable.zhuye1);
            }
            ai.setText_id("001");
            ai.setText_infos("这是我们都需要注意的...");
            ai.setText_url("http://jiangshide.com");
            appInfos.add(ai);
        }
    }

}
