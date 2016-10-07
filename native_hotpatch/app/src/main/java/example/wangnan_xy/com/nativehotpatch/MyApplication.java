package example.wangnan_xy.com.nativehotpatch;

import android.app.Application;
import android.content.Context;

/**
 * 自定义application
 * Created by wangnan on 2016/10/5.
 */

public class MyApplication extends Application {
    private static Context sContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        sContext = this;
    }


//    public static Application getApplication() {
//        return this;
//    }
}
