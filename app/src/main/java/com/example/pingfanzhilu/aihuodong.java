package com.example.pingfanzhilu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class aihuodong extends Activity {
    private WebView webview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aihuodongactivity);

        webview =(WebView)findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.xingongyi.org/activity/index.html");
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
//        int[] imageIds = new int[]
//                {
//
//                        R.drawable.shoucang1,
//                        R.drawable.shoucang2,
//                        R.drawable.shoucang3,
//                        R.drawable.shoucang4,
//                        R.drawable.shoucang5,
//                        R.drawable.shoucang1,
//                        R.drawable.shoucang2,
//                        R.drawable.shoucang3,
//                        R.drawable.shoucang4,
//                        R.drawable.shoucang5,
//                        R.drawable.shoucang1,
//                        R.drawable.shoucang2,
//                        R.drawable.shoucang3,
//                        R.drawable.shoucang4,
//                        R.drawable.shoucang5
//
//                };
//
//    public void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.aihuodongactivity);
//
//        final Gallery gallery = (Gallery) findViewById(R.id.gallery);
//
//        final ImageSwitcher switcher = (ImageSwitcher) findViewById(R.id.switcher);
//
//        switcher.setFactory(new ViewSwitcher.ViewFactory() {
//            @Override
//            public View makeView() {
//                ImageView imageView = new ImageView(aihuodong.this);
//                imageView.setBackgroundColor(0xff0000);
//                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
//                        Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT));
//
//                return imageView;
//            }
//        });
//
//        switcher.setInAnimation(AnimationUtils.loadAnimation(this,
//                android.R.anim.fade_in));
//        switcher.setInAnimation(AnimationUtils.loadAnimation(this,
//                android.R.anim.fade_out));
//
//        BaseAdapter adapter = new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return imageIds.length;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return position;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                ImageView imageView = new ImageView(aihuodong.this);
//                imageView.setImageResource(imageIds[position % imageIds.length]);
//
//                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
//                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
//                imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.
//                        Gallery_android_galleryItemBackground, 0));
//                return imageView;
//            }
//        };
//
//        gallery.setAdapter(adapter);
//        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                switcher.setImageResource(imageIds[position % imageIds.length]);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
////        getComponenets();

}


