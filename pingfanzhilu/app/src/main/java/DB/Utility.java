package DB;

import android.text.TextUtils;

import java.io.StringBufferInputStream;

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
                    user.setUsername(array[1]);
                    user.setId(id);
// 将解析出来的数据存储到User表
                    welfareDB.saveUser(user);
                }
                return true;
            }
        }
        return false;
    }
}
