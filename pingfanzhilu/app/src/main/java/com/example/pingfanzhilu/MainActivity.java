
package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TabHost tabs;
    private ImageButton zhuye;
    private ImageButton faxian;
    private ImageButton sousuo;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baseactivity);

        tabs = null;
        tabs = (TabHost)findViewById(R.id.tabhost);
        tabs.setup();
        tabs.setOnTabChangedListener(TabChangeListener);

        //设置Tab1
        zhuye = new ImageButton(this);
        zhuye.setBackgroundResource(R.drawable.zhuye1);
        //zhuye.setLayoutParams(new LinearLayout.LayoutParams(60, LinearLayout.LayoutParams.WRAP_CONTENT));
        TabSpec tab1 = tabs.newTabSpec(null);
        tab1.setIndicator(zhuye);      // 设置tab1的名称
        tab1.setContent(R.id.text1);    // 关联控件
        tabs.addTab(tab1);                // 添加tab1



        //设置Tab2
        faxian = new ImageButton(this);
        faxian.setBackgroundResource(R.drawable.faxian1);
        TabSpec tab2 = tabs.newTabSpec(null);
        tab2.setIndicator(faxian);
        tab2.setContent(R.id.text2);
        tabs.addTab(tab2);


        //设置Tab3
        sousuo = new ImageButton(this);
        sousuo.setBackgroundResource(R.drawable.sousuo1);
        TabSpec tab3 = tabs.newTabSpec(null);
        tab3.setIndicator(sousuo);
        tab3.setContent(R.id.text3);
        tabs.addTab(tab3);


    }

    private OnTabChangeListener TabChangeListener  = new OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            int j = tabs.getTabWidget().getTabCount();
            ImageButton currentView =(ImageButton) tabs.getCurrentTabView();
            for (int i = 0; i < j ; i++){
                if(tabs.getCurrentTab() == i){
                    currentView.setEnabled(false);
                }else{
                    if(tabs.getTabWidget().getChildTabViewAt(i) != null){
                        ((ImageButton)tabs.getTabWidget().getChildTabViewAt(i)).setEnabled(true);
                    }
                }
            }
            ImageButton zhiyuanzhe = (ImageButton)findViewById(R.id.ibu1);
            zhiyuanzhe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  intent1 = new Intent(MainActivity.this,zhiyuanzhe.class);
                    startActivity(intent1);
                }
            });
            ImageButton aixinjuan = (ImageButton)findViewById(R.id.ibu2);
            aixinjuan.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Intent intent2 = new Intent(MainActivity.this,aixinjuan.class);
                    startActivity(intent2);
                }
            });
            ImageButton aixingou = (ImageButton)findViewById(R.id.ibu3);
            aixingou.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     Intent intent3 = new Intent(MainActivity.this, aixingou.class);
                     startActivity(intent3);
                 }
             });
            ImageButton aihuodong = (ImageButton)findViewById(R.id.ibu4);
            aihuodong.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent4 = new Intent(MainActivity.this, aihuodong.class);
                    startActivity(intent4);
                }
            });
            ImageButton aiqiuzhu = (ImageButton)findViewById(R.id.ibu5);
            aiqiuzhu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent5 = new Intent(MainActivity.this, aiqiuzhu.class);
                    startActivity(intent5);
                }
            });
            ImageButton daikaifa = (ImageButton)findViewById(R.id.ibu6);
            daikaifa.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "此功能开发中",
                            Toast.LENGTH_SHORT).show();
                }
            });
            ImageButton gongyijiaodian = (ImageButton)findViewById(R.id.ibu12);
            gongyijiaodian.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent6 = new Intent(MainActivity.this, gongyijiaodian.class);
                    startActivity(intent6);
                }
            });
            ImageButton renwuzhongxin = (ImageButton)findViewById(R.id.ibu13);
            renwuzhongxin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent7 = new Intent(MainActivity.this, renwuzhongxin.class);
                    startActivity(intent7);
                }
            });
            ImageButton hezuojigou = (ImageButton)findViewById(R.id.ibu14);
            hezuojigou.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent8 = new Intent(MainActivity.this, hezuojigou.class);
                    startActivity(intent8);
                }
            });
            ImageButton aixinluntan = (ImageButton)findViewById(R.id.ibu15);
            aixinluntan.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent9 = new Intent(MainActivity.this, aixinluntan.class);
                    startActivity(intent9);
                }
            });
            ImageButton wangqitupian = (ImageButton)findViewById(R.id.ibu16);
            wangqitupian.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent10 = new Intent(MainActivity.this, wangqitupian.class);
                    startActivity(intent10);
                }
            });
            ImageButton titleMe = (ImageButton) findViewById(R.id.ibu11);
            titleMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "You clicked Edit button",
                            Toast.LENGTH_SHORT).show();
                }
            });
            Button sousuo = (Button) findViewById(R.id.bu1);
            sousuo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "你好，没完善此功能",
                            Toast.LENGTH_SHORT).show();
                }
            });
            ImageButton gerenzhongxin = (ImageButton)findViewById(R.id.ibu11);
            gerenzhongxin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent11 = new Intent(MainActivity.this, gerenzhongxin.class);
                    startActivity(intent11);
                }
            });
        }
    };;
}