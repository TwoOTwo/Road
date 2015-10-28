package com.example.pingfanzhilu;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import model.vulunteerevent;


public class AppAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<vulunteerevent> appInfos;
//    private LayoutInflater layoutInflater;
//    public final class ListItemView{
//        public ImageView image;
//        public TextView title;
//        public TextView id;
//        public TextView info;
//        public Button detail;
//
//    }

    public AppAdapter(Context c) {
        this.mContext = c;
    }

    public AppAdapter(Context c, ArrayList<vulunteerevent> appInfos) {
        this.mContext = c;
//        layoutInflater = LayoutInflater.from(c);
        this.appInfos = appInfos;
    }

    public int getCount() {
        return appInfos.size();
    }

    public Object getItem(int position) {
        return appInfos.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    /**
     * get view
     */
    public View getView(final int position, View convertView, ViewGroup parent) {
//        ListItemView listItemView = null;
//        final  int selectID = position;
        if(appInfos == null){
            return null;
        }
        if(convertView == null){
            AppView appView = new AppView(mContext);
            appView.updateView(appInfos.get(position));
            convertView = appView;
//            convertView = layoutInflater.inflate(R.layout.item,null);
//            listItemView.detail = (Button)convertView.findViewById(R.id.button3);
//            listItemView.image = (ImageView)convertView.findViewById(R.id.images_id);
//            listItemView.detail.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            listItemView.image.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    showDetailInfo(position);
//                }
//            });

        }else{
            ((AppView)convertView).updateView(appInfos.get(position));
        }
        return convertView;
    }


    public  void showDetailInfo(int clickID)
    {
        new AlertDialog.Builder(mContext).setTitle("详情："+appInfos.get(clickID).getText_id()).setMessage(appInfos.get(clickID).getText_infos().toString()).setPositiveButton("确定", null).show();
    }
}


