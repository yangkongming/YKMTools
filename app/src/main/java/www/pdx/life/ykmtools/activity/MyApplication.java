package www.pdx.life.ykmtools.activity;

import android.app.Application;
import android.content.Context;
import www.pdx.life.ykmtools.service.MyIntentService;

/**
 * <pre>
 *     author : wenxin
 *     e-mail : xxx@xx
 *     time   : 2017/03/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //启动IntentService来异步处理服务,
        //一些复杂的耗时逻辑放在MyIntentService里面
        MyIntentService.start(this);
    }
}
