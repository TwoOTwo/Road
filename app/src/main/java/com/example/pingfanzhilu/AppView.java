package com.example.pingfanzhilu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pingfanzhilu.R;
import com.example.pingfanzhilu.Appinfos;

/**
 * Created by Hua on 2015/10/18.
 */
public class AppView extends LinearLayout
{
    private Context mContext;
    private ImageView image_id;
    private TextView text_id,text_info,text_url;

    /**
     *
     * @param context
     */
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
    }

    /**
     *
     * @param ai
     */
    public void updateView(Appinfos ai){
        image_id.setImageResource(ai.getImages());
        text_id.setText(ai.getText_id());
        text_info.setText(ai.getText_infos());
        text_url.setText(ai.getText_url());
    }
}

