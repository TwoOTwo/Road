package com.example.pingfanzhilu;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

import model.vulunteerevent;

public class HelloTabHost extends Activity {
    private Context context;
    private ListView listView2,listView3,listView4,listView5;
    private ArrayList<vulunteerevent> appInfos;
    private AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aixingou_1);

        TabHost th=(TabHost)findViewById(R.id.tabhost);
        th.setup();            //初始化TabHost容器

        getComponenets1();//推荐商品
        getComponenets2();//爱心数码
        getComponenets3();//爱心生活
        getComponenets4();//爱心超市



        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        th.addTab(th.newTabSpec("tab1").setIndicator("推荐商品", this.getResources().getDrawable(R.drawable.jifen)).setContent(R.id.tab1));
        th.addTab(th.newTabSpec("tab2").setIndicator("爱心数码",null).setContent(R.id.tab2));
        th.addTab(th.newTabSpec("tab3").setIndicator("爱心生活", null).setContent(R.id.tab3));
        th.addTab(th.newTabSpec("tab4").setIndicator("爱心超市", null).setContent(R.id.tab4));

        //上面的null可以为getResources().getDrawable(R.drawable.图片名)设置图标
//
//        //绑定Layout中的LsitVIew
//        ListView list = (ListView)findViewById(R.id.listView01);
//        //生成动态数组，加入数据
//        ArrayList<HashMap<String,Object>> listItem = new ArrayList<HashMap<String, Object>>();
//        for(int i=0;i<7;i++)
//        {
//            HashMap<String , Object> map = new HashMap<String , Object>();
//            map.put("ItemImage",R.drawable.shoucang6);
//            map.put("ItemTitle","Level"+1);
//            map.put("ItemText","Finish in 1 Min 54 Secs , 70 Moves");
//            listItem.add(map);
//
//        }
//        //生成适配器的Item和动态数组对应的元素
//        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,   //数据源
//                R.layout.list_items,                                      //ListItem的XML实现
//                new String[]{"Itemimage ","ItemTitle","ItemText"},     //动态数组与Item对应的子项
//                new int[]{R.id.ItemImage,R.id.ItemTitle,R.id.ItemText}  //IamgeItem的XML文件中有一个ImageView，两个TextView id
//                );
//        //添加并显示
//        list.setAdapter(listItemAdapter);
//        //添加点击
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView <?> arg0,View arg1,int arg2,long arg3) {
//                setTitle("单击了" +arg2 +"个项目");
//            }
//        });
//        //添加长按点击
//        listView2.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
//            @Override
//            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//                menu.setHeaderTitle("长按菜单-Context");
//                menu.add(0,0,0,"弹出长按菜单");
//                menu.add(0,2,0,"弹出长按菜单1");
//
//            }
//        });
    }
//        //长按菜单相应函数
//    public boolean onContextItemSelectd(MenuItem item){
//        setTitle("单击了长按菜单里面的第"+item.getItemId()+"个项目");
//        return super.onContextItemSelected(item);
//
// }

//
//
//    //推荐商品
    public void getComponenets1(){
        this.context = this;
        listView2 = (ListView) findViewById(R.id.listView2);
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas1();
        appAdapter = new AppAdapter(context,appInfos);
        listView2.setAdapter(appAdapter);


    }

    public void loadDatas1(){
        for (int i = 1; i < 7; i++) {
            vulunteerevent ai = new vulunteerevent();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");


            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");
            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");
            }else if(i == 5){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("005");
                ai.setText_infos("这是我们都需要注意的...");
                ai.setText_url("http://jiangshide.com");
            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");
            }
            //ai.setText_id("001");

            appInfos.add(ai);
        }

    }


    //爱心数码
    public void getComponenets2(){
        this.context = this;
        listView3 = (ListView) findViewById(R.id.listView3);
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas2();
        appAdapter = new AppAdapter(context,appInfos);
        listView3.setAdapter(appAdapter);

    }


    public void loadDatas2(){
        for (int i = 1; i < 7; i++) {
            vulunteerevent ai = new vulunteerevent();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");


            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 5){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }
            //ai.setText_id("001");

            appInfos.add(ai);
        }

    }
    //爱心生活
    public void getComponenets3(){
        this.context = this;
        listView4 = (ListView) findViewById(R.id.listView4);
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas3();
        appAdapter = new AppAdapter(context,appInfos);
        listView4.setAdapter(appAdapter);

    }


    public void loadDatas3(){
        for (int i = 1; i < 7; i++) {
            vulunteerevent ai = new vulunteerevent();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");


            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 5){
                ai.setImages(R.drawable.chaoshi1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }
            //ai.setText_id("001");

            appInfos.add(ai);
        }

    }
    //爱心超市
    public void getComponenets4(){
        this.context = this;
        listView5 = (ListView) findViewById(R.id.listView5);
        appInfos = new ArrayList<vulunteerevent>();
        loadDatas4();
        appAdapter = new AppAdapter(context,appInfos);
        listView5.setAdapter(appAdapter);

    }


    public void loadDatas4(){
        for (int i = 1; i < 7; i++) {
            vulunteerevent ai = new vulunteerevent();
            if(i == 1){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");



            }else if(i == 2){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 3){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 4){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 5){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }else if(i == 6){
                ai.setImages(R.drawable.zhuye1);
                ai.setText_id("商品名称：");
                ai.setText_infos("商品价格：");
                ai.setText_url("商品折扣：");

            }
            //ai.setText_id("001");

            appInfos.add(ai);
        }

    }

    /**
     * ViewPager实现的轮播图广告自定义视图，如京东首页的广告轮播图效果；
     * 既支持自动轮播页面也支持手势滑动切换页面
     * @author caizhiming
     *
     */
//
//    public static class SlideShowView extends FrameLayout {
//
//        //轮播图图片数量
//        private final static int IMAGE_COUNT = 5;
//        //自动轮播的时间间隔
//        private final static int TIME_INTERVAL = 5;
//        //自动轮播启用开关
//        private final static boolean isAutoPlay = true;
//
//        //自定义轮播图的资源ID
//        private int[] imagesResIds;
//        //放轮播图片的ImageView 的list
//        private List<ImageView> imageViewsList;
//        //放圆点的View的list
//        private List<View> dotViewsList;
//
//        private ViewPager viewPager;
//        //当前轮播页
//        private int currentItem  = 0;
//        //定时任务
//        private ScheduledExecutorService scheduledExecutorService;
//        //Handler
//        private Handler handler = new Handler(){
//
//            @Override
//            public void handleMessage(Message msg) {
//                // TODO Auto-generated method stub
//                super.handleMessage(msg);
//                viewPager.setCurrentItem(currentItem);
//            }
//
//        };
//
//        public SlideShowView(Context context) {
//            this(context,null);
//            // TODO Auto-generated constructor stub
//        }
//        public SlideShowView(Context context, AttributeSet attrs) {
//            this(context, attrs, 0);
//            // TODO Auto-generated constructor stub
//        }
//        public SlideShowView(Context context, AttributeSet attrs, int defStyle) {
//            super(context, attrs, defStyle);
//            // TODO Auto-generated constructor stub
//            initData();
//            initUI(context);
//            if(isAutoPlay){
//                startPlay();
//            }
//
//        }
//        /**
//         * 开始轮播图切换
//         */
//        private void startPlay(){
//            scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//            scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, 4, TimeUnit.SECONDS);
//        }
//        /**
//         * 停止轮播图切换
//         */
//        private void stopPlay(){
//            scheduledExecutorService.shutdown();
//        }
//        /**
//         * 初始化相关Data
//         */
//        private void initData(){
//            imagesResIds = new int[]{
//                    R.drawable.shoucang1,
//                    R.drawable.shoucang2,
//                    R.drawable.shoucang3,
//                    R.drawable.shoucang4,
//                    R.drawable.shoucang5,
//
//            };
//            imageViewsList = new ArrayList<ImageView>();
//            dotViewsList = new ArrayList<View>();
//
//        }
//        /**
//         * 初始化Views等UI
//         */
//        private void initUI(Context context){
//            LayoutInflater.from(context).inflate(R.layout.photoview, this, true);
//            for(int imageID : imagesResIds){
//                ImageView view =  new ImageView(context);
//                view.setImageResource(imageID);
//                view.setScaleType(ImageView.ScaleType.FIT_XY);
//                imageViewsList.add(view);
//            }
//            dotViewsList.add(findViewById(R.id.v_dot1));
//            dotViewsList.add(findViewById(R.id.v_dot2));
//            dotViewsList.add(findViewById(R.id.v_dot3));
//            dotViewsList.add(findViewById(R.id.v_dot4));
//            dotViewsList.add(findViewById(R.id.v_dot5));
//
//            viewPager = (ViewPager) findViewById(R.id.viewPager);
//            viewPager.setFocusable(true);
//
//            viewPager.setAdapter(new MyPagerAdapter());
//            viewPager.setOnPageChangeListener(new MyPageChangeListener());
//        }
//
//        /**
//         * 填充ViewPager的页面适配器
//         * @author caizhiming
//         */
//        private class MyPagerAdapter  extends PagerAdapter {
//
//            @Override
//            public void destroyItem(View container, int position, Object object) {
//                // TODO Auto-generated method stub
//                //((ViewPag.er)container).removeView((View)object);
//                ((ViewPager)container).removeView(imageViewsList.get(position));
//            }
//
//            @Override
//            public Object instantiateItem(View container, int position) {
//                // TODO Auto-generated method stub
//                ((ViewPager)container).addView(imageViewsList.get(position));
//                return imageViewsList.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                // TODO Auto-generated method stub
//                return imageViewsList.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View arg0, Object arg1) {
//                // TODO Auto-generated method stub
//                return arg0 == arg1;
//            }
//            @Override
//            public void restoreState(Parcelable arg0, ClassLoader arg1) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public Parcelable saveState() {
//                // TODO Auto-generated method stub
//                return null;
//            }
//
//            @Override
//            public void startUpdate(View arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void finishUpdate(View arg0) {
//                // TODO Auto-generated method stub
//
//            }
//
//        }
//        /**
//         * ViewPager的监听器
//         * 当ViewPager中页面的状态发生改变时调用
//         * @author caizhiming
//         */
//        private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
//
//            boolean isAutoPlay = false;
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//                // TODO Auto-generated method stub
//                switch (arg0) {
//                    case 1:// 手势滑动，空闲中
//                        isAutoPlay = false;
//                        break;
//                    case 2:// 界面切换中
//                        isAutoPlay = true;
//                        break;
//                    case 0:// 滑动结束，即切换完毕或者加载完毕
//                        // 当前为最后一张，此时从右向左滑，则切换到第一张
//                        if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1 && !isAutoPlay) {
//                            viewPager.setCurrentItem(0);
//                        }
//                        // 当前为第一张，此时从左向右滑，则切换到最后一张
//                        else if (viewPager.getCurrentItem() == 0 && !isAutoPlay) {
//                            viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
//                        }
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void onPageSelected(int pos) {
//                // TODO Auto-generated method stub
//
//                currentItem = pos;
//                for(int i=0;i < dotViewsList.size();i++){
//                    if(i == pos){
//                        ((View)dotViewsList.get(pos)).setBackgroundResource(R.drawable.abc_list_longpressed_holo);
//                    }else {
//                        ((View)dotViewsList.get(i)).setBackgroundResource(R.drawable.abc_list_pressed_holo_light);
//                    }
//                }
//            }
//
//        }
//
//        /**
//         *执行轮播图切换任务
//         *@author caizhiming
//         */
//        private class SlideShowTask implements Runnable{
//
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                synchronized (viewPager) {
//                    currentItem = (currentItem+1)%imageViewsList.size();
//                    handler.obtainMessage().sendToTarget();
//                }
//            }
//
//        }
//        /**
//         * 销毁ImageView资源，回收内存
//         * @author caizhiming
//         */
//        private void destoryBitmaps() {
//
//            for (int i = 0; i < IMAGE_COUNT; i++) {
//                ImageView imageView = imageViewsList.get(i);
//                Drawable drawable = imageView.getDrawable();
//                if (drawable != null) {
//                    //解除drawable对view的引用
//                    drawable.setCallback(null);
//                }
//            }
//        }
//
//    }
}