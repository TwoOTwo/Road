package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import model.vulunteerevent;


public class zhiyuanzhe extends Activity {
    private Context context;
    private ListView listView;
    private ArrayList<vulunteerevent> appInfos;
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
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas();
        appAdapter = new AppAdapter(context,appInfos);
        listView.setAdapter(appAdapter);
    }


    public void loadDatas(){
        for (int i = 1; i < 10; i++) {
            vulunteerevent ai = new vulunteerevent();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("001");
                ai.setText_infos("中国梦，七彩梦");
                ai.setText_url("茂名");
            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("002");
                ai.setText_infos("心手相牵，爱在东航");
                ai.setText_url("长春");
            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("003");
                ai.setText_infos("七彩课堂-快乐伴假期");
                ai.setText_url("合肥");
            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("004");
                ai.setText_infos("关爱农民工 “春蕾”志愿者在行动");
                ai.setText_url("南岸");
            }else if(i == 5){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("005");
                ai.setText_infos("奇趣大课堂 关爱农民工子女");
                ai.setText_url("长春");
            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("006");
                ai.setText_infos("让每个孩子拥有七彩童年");
                ai.setText_url("孝义");
            }else if(i == 7){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("007");
                ai.setText_infos("七彩课堂”为乡里孩子放飞梦想");
                ai.setText_url("沈阳");
            }else if(i == 8){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("008");
                ai.setText_infos("听留守孩子们的小心愿和思念");
                ai.setText_url("陕西 ");
            }else if(i == 9){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("009");
                ai.setText_infos("“七彩小屋”温暖“流动花朵”");
                ai.setText_url("天津");
            }
            appInfos.add(ai);
        }
    }

}
