
package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import model.User;

public class MainActivity extends Activity {
    private TabHost tabs;
    private ImageButton zhuye;
    private ImageButton faxian;
    private ImageButton sousuo;

    private User user;

    private EditText editText;
    private Button submit1;
    private WebView webView;
    private TextView tips;
    private WebSettings webSettings;
    private Handler handler = new Handler();
//    private User user;
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

        //获得从登陆传来的数据
//        user = new User();
//        user = (User)getIntent().getSerializableExtra("user_data");
//        LayoutInflater layoutInflater = this.getLayoutInflater();
//        View view = layoutInflater.inflate(R.layout.gerenzhongxinactivity,null);
//        TextView jifen = (TextView)view.findViewById(R.id.jifen);
//        TextView time = (TextView)view.findViewById(R.id.time);
//        jifen.setText(String.valueOf(user.getIntegral()));
//        time.setText(String.valueOf(user.getThelength()));


        //设置Tab3
        sousuo = new ImageButton(this);
        sousuo.setBackgroundResource(R.drawable.sousuo1);
        TabSpec tab3 = tabs.newTabSpec(null);
        tab3.setIndicator(sousuo);
        tab3.setContent(R.id.text3);
        tabs.addTab(tab3);

        editText = (EditText) findViewById(R.id.editText);
        tips = (TextView) findViewById(R.id.tips);
        submit1 = (Button) findViewById(R.id.submit);
        webView = (WebView) findViewById(R.id.toutput);

        webSettings = webView.getSettings();
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
        webSettings.setSupportZoom(false);

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        submit1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().length() == 0) {
                    Toast.makeText(MainActivity.this, "请输入查询的词", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    tips.setVisibility(TextView.VISIBLE);
                    webView.setVisibility(WebView.VISIBLE);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            webView.loadUrl("http://www.baike.com/wiki/" + editText.getText().toString());
                        }
                    });

                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
//        sousuo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent1 = new Intent(MainActivity.this, Search.class);
//                startActivity(intent1);
//            }
//        });



    private OnTabChangeListener TabChangeListener  = new OnTabChangeListener() {

        @Override
        public void onTabChanged(String tabId) {
            int j = tabs.getTabWidget().getTabCount();
            ImageButton currentView = (ImageButton) tabs.getCurrentTabView();
            for (int i = 0; i < j; i++) {
                if (tabs.getCurrentTab() == i) {
                    currentView.setEnabled(false);
                } else {
                    if (tabs.getTabWidget().getChildTabViewAt(i) != null) {
                        ((ImageButton) tabs.getTabWidget().getChildTabViewAt(i)).setEnabled(true);
                    }
                }
            }
            ImageButton zhiyuanzhe = (ImageButton) findViewById(R.id.ibu1);
            zhiyuanzhe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(MainActivity.this, zhiyuanzhe.class);
                    startActivity(intent1);
                }
            });
            ImageButton aixinjuan = (ImageButton) findViewById(R.id.ibu2);
            aixinjuan.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent2 = new Intent(MainActivity.this, com.example.pingfanzhilu.aixinjuan.class);
                    startActivity(intent2);
                }
            });
            ImageButton aixingou = (ImageButton) findViewById(R.id.ibu3);
            aixingou.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent3 = new Intent(MainActivity.this, HelloTabHost.class);
                    startActivity(intent3);
                }
            });
            ImageButton aihuodong = (ImageButton) findViewById(R.id.ibu4);
            aihuodong.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent4 = new Intent(MainActivity.this, com.example.pingfanzhilu.aihuodong.class);
                    startActivity(intent4);
                }
            });
            ImageButton aiqiuzhu = (ImageButton) findViewById(R.id.ibu5);
            aiqiuzhu.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent5 = new Intent(MainActivity.this, com.example.pingfanzhilu.aiqiuzhu.class);
                    startActivity(intent5);
                }
            });
            ImageButton daikaifa = (ImageButton) findViewById(R.id.ibu6);
            daikaifa.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "此功能开发中",
                            Toast.LENGTH_SHORT).show();
                }
            });
            ImageButton gongyijiaodian = (ImageButton) findViewById(R.id.ibu12);
            gongyijiaodian.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent6 = new Intent(MainActivity.this, com.example.pingfanzhilu.gongyijiaodian.class);
                    startActivity(intent6);
                }
            });
            ImageButton renwuzhongxin = (ImageButton) findViewById(R.id.ibu13);
            renwuzhongxin.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent7 = new Intent(MainActivity.this, hezuojigou.renwuzhongxin.class);
                    startActivity(intent7);
                }
            });
            ImageButton hezuojigou = (ImageButton) findViewById(R.id.ibu14);
            hezuojigou.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent8 = new Intent(MainActivity.this, com.example.pingfanzhilu.hezuojigou.class);
                    startActivity(intent8);
                }
            });
            ImageButton aixinluntan = (ImageButton) findViewById(R.id.ibu15);
            aixinluntan.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent9 = new Intent(MainActivity.this, com.example.pingfanzhilu.aixinluntan.class);
                    startActivity(intent9);
                }
            });
            ImageButton wangqitupian = (ImageButton) findViewById(R.id.ibu16);
            wangqitupian.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent10 = new Intent(MainActivity.this, com.example.pingfanzhilu.hezuojigou.wangqitupian.class);
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

            ImageButton gerenzhongxin = (ImageButton) findViewById(R.id.ibu11);
            gerenzhongxin.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent11 = new Intent(MainActivity.this, com.example.pingfanzhilu.gerenzhongxin.class);
                    startActivity(intent11);
                }
            });


            
        }
    };

//    public static class zhiyuanzhe extends Activity {
//        private WebView webview;
//        public void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.zhiyuanzheactivity);
//
//            webview =(WebView)findViewById(R.id.webview1);
//            webview.getSettings().setJavaScriptEnabled(true);
//            webview.loadUrl("http://www.xingongyi.org/");
//            webview.setWebViewClient(new HelloWebViewClient());
//        }
//        public boolean onKeyDown(int keyCode,KeyEvent event){
//            if((keyCode == KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
//                webview.goBack();
//                return true;
//            }
//            return false;
//        }
//
//        private class HelloWebViewClient extends WebViewClient {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view,String url){
//                view.loadUrl(url);
//                return true;
//            }
//        }

 //   }
}