package com.example.pingfanzhilu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

public class HelloTabHost extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aixingou_1);

        TabHost th=(TabHost)findViewById(R.id.tabhost);
        th.setup();            //初始化TabHost容器

        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        th.addTab(th.newTabSpec("tab1").setIndicator("推荐商品",this.getResources().getDrawable(R.drawable.fanhui2)).setContent(R.id.tab1));
        th.addTab(th.newTabSpec("tab2").setIndicator("家用电器",null).setContent(R.id.tab2));
        th.addTab(th.newTabSpec("tab3").setIndicator("手机数码", null).setContent(R.id.tab3));
        th.addTab(th.newTabSpec("tab4").setIndicator("电脑办公", null).setContent(R.id.tab4));

        //上面的null可以为getResources().getDrawable(R.drawable.图片名)设置图标

    }
}