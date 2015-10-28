package service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import receiver.AutoUpdataReceiver;
import util.HttpCallbackListener;
import util.HttpUtil;
import util.Utility;


public class AutoUpdateService extends Service
{
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public int onStrartCommand(Intent intent,int flags,int startId)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
        int anHour = 8*60*1000;
        long triggerAtTime = SystemClock.elapsedRealtime()+anHour;
        Intent i = new Intent(this, AutoUpdataReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,i,0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);
        return  super.onStartCommand(intent,flags,startId);
    }

    private void updataPublicWelfare()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String id = sharedPreferences.getString("", "");
        String address ="http://localhost:8080/";
//        String address = "http://www.gongyi.com.cn/data/"+id+".html";
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
            @Override
            public void onFinish(String response) {
                Utility.handleWeatherResponse(AutoUpdateService.this,response);
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
    public void onError(Exception e)
    {
        e.printStackTrace();
    }
}
