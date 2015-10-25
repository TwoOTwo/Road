package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import model.vulunteerevent;


public class aixinjuan extends Activity {
    private Context mContext;
    private ListView listView;
    private ArrayList<vulunteerevent> appInfos;
    private AppAdapter appAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aixinjuanactivity);
        getComponenets();
    }

    /**
     * componenet
     */
    public void getComponenets(){
        this.mContext = this;
        listView = (ListView) findViewById(R.id.listView);
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas();
        appAdapter = new AppAdapter(mContext,appInfos);
        listView.setAdapter(appAdapter);
    }

    /**
     * load datas
     */
    public void loadDatas(){
        for (int i = 0; i < 10; i++) {
            vulunteerevent ai = new vulunteerevent();
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
            }
            ai.setText_id("001");
            ai.setText_infos("这是我们都需要注意的...");
            ai.setText_url("http://jiangshide.com");
            appInfos.add(ai);
        }
    }
}
