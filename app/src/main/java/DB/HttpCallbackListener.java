package DB;

/**
 * Created by Hua on 2015/10/13.
 */
public interface HttpCallbackListener
{
    void onFinish(String response);
    void onError(Exception e);
}
