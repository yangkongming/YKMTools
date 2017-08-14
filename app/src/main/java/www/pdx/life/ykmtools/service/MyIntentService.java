package www.pdx.life.ykmtools.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import www.pdx.life.ykmtools.manager.GreenDaoManager;

/**
 * <pre>
 *     author : wenxin
 *     e-mail : xxx@xx
 *     time   : 2017/08/14
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("wenxin");
    }

    private static final String ACTION_INIT_WHEN_APP_CREATE
            = "com.anly.gthubapp.service.action.INIT";

    public static void start(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_INIT_WHEN_APP_CREATE);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //可以将application里面的耗时操作的逻辑放到IntentService里面
        GreenDaoManager.initDatabase();
        try {
            for (int i = 1; i < 6; i++) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
