package com.example.pingfanzhilu;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LAN on 2015/10/28.
 */
public class MyListView3 extends ListActivity {


    // private List<String> data = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.item_aixingou,
                new String[]{"id","title","info","img"},
                new int[]{R.id.text_id,R.id.text_info,R.id.text_url,R.id.images_id});
        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id","001");
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.zhuye1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("id","001");
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.zhuye1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("id","001");
        map.put("title", "G1");
        map.put("info", "google 1");
        map.put("img", R.drawable.zhuye1);
        list.add(map);

        return list;
    }
}