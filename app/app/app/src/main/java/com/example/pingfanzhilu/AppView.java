package com.example.pingfanzhilu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import model.vulunteerevent;

/**
 * Created by Hua on 2015/10/18.
 */
public class AppView extends LinearLayout
{
    private Context mContext;
    private ImageView image_id;
    private TextView text_id,text_info,text_url;
    private vulunteerevent appinfos;
    private ArrayList<vulunteerevent> appInfos;



    public AppView(Context context) {
        super(context);
        this.mContext = context;
        initilize(context);
    }

    /**
     *
     * @param c
     */
    public void initilize(Context c){
        this.mContext = c;
        View view = LayoutInflater.from(this.mContext).inflate(R.layout.item, null);
        image_id = (ImageView) view.findViewById(R.id.images_id);
        text_id = (TextView) view.findViewById(R.id.text_id);
        text_info = (TextView) view.findViewById(R.id.text_info);
        text_url = (TextView) view.findViewById(R.id.text_url);
        addView(view);
        image_id.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              showDetailInfo(getVerticalScrollbarPosition());

            }
        });
        final Button button =(Button)findViewById(R.id.button3);
        View view1 = LayoutInflater.from(this.mContext).inflate(R.layout.gerenzhongxinactivity, null);
        final TextView textView = (TextView)findViewById(R.id.jifen);
        final TextView textView1 = (TextView)findViewById(R.id.time);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (textView.getText().toString().equals(null)) {

                    } else {
                        button.setText("已报名");
                        int i = Integer.parseInt(textView.getText().toString());
                        int j = Integer.parseInt(textView1.getText().toString());
                        int jifen = i+50;
                        int time = j+2;
                        textView.setText(jifen);
                        textView.setText(time);
                    }
                }catch (NullPointerException e)
                {
                    Toast.makeText(mContext, "请注册或登陆", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     *
     * @param ai
     */
    public void updateView(vulunteerevent ai){
        image_id.setImageResource(ai.getImages());
        text_id.setText(ai.getText_id());
        text_info.setText(ai.getText_infos());
        text_url.setText(ai.getText_url());
    }
    public  void showDetailInfo(int clickID)
    {
        new android.app.AlertDialog.Builder(mContext).setTitle("详情：")
                .setPositiveButton("确定", null).show();
    }
}

