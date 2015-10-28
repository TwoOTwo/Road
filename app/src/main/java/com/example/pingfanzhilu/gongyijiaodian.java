package com.example.pingfanzhilu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by 杨~ on 2015/10/14.
 */
public class gongyijiaodian extends Activity {
    private WebView webview;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gongyijiaodianactivity);

        webview =(WebView)findViewById(R.id.webview2);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.xingongyi.org/index/newslist.html");
        webview.setWebViewClient(new HelloWebViewClient());

    }
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK)&&webview.canGoBack()){
            webview.goBack();
            return true;
        }
        return false;
    }

    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }


}
