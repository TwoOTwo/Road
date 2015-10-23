package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 杨~ on 2015/10/14.
 */
public class aixingou extends Activity{

    private Context mContext;
    private ListView listView;
    private ArrayList<Appinfos> appInfos;
    private AppAdapter appAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aixingouactivity);
        getComponenets();
    }


    /**
     * componenet
     */

    public void getComponenets(){
        this.mContext = this;
        listView = (ListView) findViewById(R.id.listView);
        appInfos = new ArrayList<Appinfos>();
        loadDatas();
        appAdapter = new AppAdapter(mContext,appInfos);
        listView.setAdapter(appAdapter);
    }


    public void loadDatas(){
        for (int i = 0; i < 10; i++) {
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
            }
            ai.setText_id("001");
            ai.setText_infos("这是我们都需要注意的...");
            ai.setText_url("http://jiangshide.com");
            appInfos.add(ai);
        }
    }

}
