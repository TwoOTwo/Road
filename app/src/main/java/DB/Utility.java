package DB;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Hua on 2015/10/14.
 */
//解析和处理服务器返回公益事件数据
public class Utility
{
    public synchronized static boolean handleWelfareResponse(WelfareDB welfareDB, String response)
    {
        if(!TextUtils.isEmpty(response))
        {
            String[] allwelfare =response.split(",");
            if(allwelfare != null&& allwelfare.length>0)
            {
                for (String p :allwelfare)
                {
                    String[] array = p.split("\\|");
                    Event event = new Event();
                    event.setThing(array[0]);
                    event.setAddress(array[1]);
                    welfareDB.saveEvent(event);
                }
                return true;
            }
        }
    return false;
    }

    public static boolean handleCountiesResponse( WelfareDB welfareDB, String response, int id) {
        if (!TextUtils.isEmpty(response)) {
            String[] allUser = response.split(",");
            if (allUser != null && allUser.length > 0) {
                for (String c : allUser) {
                    String[] array = c.split("\\|");
                    User user = new User();
                    user.setAccount(array[0]);
                    user.setPassword(array[1]);
                    user.setId(id);
// 将解析出来的数据存储到User表
                    welfareDB.saveUser(user);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析服务器返回的JSON数据，并将解析出的数据存储到本地。
     */
    public static void handleWeatherResponse(Context context, String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject eventInfo = jsonObject.getJSONObject("Eventinfo");
            String thing = eventInfo.getString("Thing");
            String address = eventInfo.getString("Address");
            String publishTime = eventInfo.getString("ptime");
            saveEventrInfo(context, thing, address, publishTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void saveEventrInfo(Context context, String thing, String address,  String publishTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("Thing", thing);
        editor.putString("Address", address);
        editor.putString("publish_time", publishTime);
        editor.putString("current_date", sdf.format(new Date()));
        editor.commit();
    }
}
