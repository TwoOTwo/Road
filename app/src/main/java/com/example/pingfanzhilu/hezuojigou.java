package com.example.pingfanzhilu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pingfanzhilu.R;

/**
 * Created by 杨~ on 2015/10/15.
 */
public class hezuojigou extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hezuojigouactivity);

    }

    /**
     * Created by 杨~ on 2015/10/15.
     */
    public static class renwuzhongxin extends Activity{
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.renwuzhongxinactivity);

        }
    }

    public static class Search extends Activity
    {
        private EditText editText;
        private Button submit1;
        private WebView webView;
        private TextView tips;
        private WebSettings webSettings;
        private Handler handler = new Handler();

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sousuoactivity1);

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
                    Toast.makeText(Search.this, "aaaaaaaaaaaa", Toast.LENGTH_SHORT).show();
                    if (editText.getText().toString().length() == 0) {
                        Toast.makeText(Search.this, "请输入查询的词", Toast.LENGTH_SHORT).show();
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
    }

    /**
     * Created by 杨~ on 2015/10/15.
     */

}
