package com.example.pingfanzhilu;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class AppAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Appinfos> appInfos;

    public AppAdapter(Context c) {
        this.mContext = c;
    }

    public AppAdapter(Context c,ArrayList<Appinfos> appInfos) {
        this.mContext = c;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(appInfos == null){
            return null;
        }
        if(convertView == null){
            AppView appView = new AppView(mContext);
            appView.updateView(appInfos.get(position));
            convertView = appView;
        }else{
            ((AppView)convertView).updateView(appInfos.get(position));
        }
        return convertView;
    }

}


