package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import model.vulunteerevent;



public class aixinjuan extends Activity {
    private Context mContext;
    private ListView listView;
    private ArrayList<vulunteerevent> appInfos;
    private AppAdapter appAdapter;

    int[] imageIds = new int[]
            {

                    R.drawable.shoucang1,
                    R.drawable.shoucang2,
                    R.drawable.shoucang3,
                    R.drawable.shoucang4,
                    R.drawable.shoucang5,
                    R.drawable.shoucang1,
                    R.drawable.shoucang2,
                    R.drawable.shoucang3,
                    R.drawable.shoucang4,
                    R.drawable.shoucang5,
                    R.drawable.shoucang1,
                    R.drawable.shoucang2,
                    R.drawable.shoucang3,
                    R.drawable.shoucang4,
                    R.drawable.shoucang5

            };

    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aixinjuanactivity);

        final Gallery gallery = (Gallery) findViewById(R.id.gallery);

        final ImageSwitcher switcher = (ImageSwitcher) findViewById(R.id.switcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(aixinjuan.this);
                imageView.setBackgroundColor(0xff0000);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT));

                return imageView;
            }
        });

        switcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        switcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                ImageView imageView = new ImageView(aixinjuan.this);
                imageView.setImageResource(imageIds[position % imageIds.length]);

                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(300, 200));
                TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
                imageView.setBackgroundResource(typedArray.getResourceId(R.styleable.
                        Gallery_android_galleryItemBackground,0));
                return imageView;
            }
        };

        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                switcher.setImageResource(imageIds[position % imageIds.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        getComponenets();
    }

    /**
     * componenet
     */
//    public void getComponenets(){
//        this.mContext = this;
//        listView = (ListView) findViewById(R.id.listView);
//        appInfos = new ArrayList<vulunteerevent>();
//        loadDatas();
//        appAdapter = new AppAdapter(mContext,appInfos);
//        listView.setAdapter(appAdapter);
//    }

    /**
     * load datas
     */
//    public void loadDatas(){
//        for (int i = 0; i < 10; i++) {
//            vulunteerevent ai = new vulunteerevent();
//            if(i == 1){
//                ai.setImages(R.drawable.zhuye1);
//            }else if(i == 2){
//                ai.setImages(R.drawable.zhuye1);
//            }else if(i == 3){
//                ai.setImages(R.drawable.zhuye1);
//            }else if(i == 4){
//                ai.setImages(R.drawable.zhuye1);
//            }else if(i == 5){
//                ai.setImages(R.drawable.zhuye1);
//            }else if(i == 6){
//                ai.setImages(R.drawable.zhuye1);
//            }
//            ai.setText_id("001");
//            ai.setText_infos("这是我们都需要注意的...");
//            ai.setText_url("http://jiangshide.com");
//            appInfos.add(ai);
//        }
//    }
}
