package IMSI;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by Hua on 2015/10/21.
 */
public class PhoneInfo
{
    private TelephonyManager telephonyManager;
    private String IMSI;
    private Context context1;
    public PhoneInfo(Context context)
    {
        context1 = context;
        telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

    }
    //获取电话号码
    public String getNativePhoneNumber()
    {
        String NativePhoneNumber = null;
        NativePhoneNumber = telephonyManager.getLine1Number();
        return NativePhoneNumber;
    }


    //获取手机服务商信息
    public String getProvidersname()
    {
        String Providersname = "N/A";
        try
        {
            IMSI = telephonyManager.getSubscriberId();
            if(IMSI.startsWith("46000")||IMSI.startsWith("46002"))
            {
                Providersname = "z中国移动";

            }else if (IMSI.startsWith("46001"))
            {
                Providersname = "中国联通";

            }
            else if(IMSI.startsWith("46003"))
            {
                Providersname = "中国电信";
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return  Providersname;

    }
    public String getPhoneInfo()
    {
        TelephonyManager telephonyManager = (TelephonyManager)context1.getSystemService(Context.TELEPHONY_SERVICE);
        StringBuilder sb = new StringBuilder();
        return telephonyManager.getLine1Number().toString();
    }
}
