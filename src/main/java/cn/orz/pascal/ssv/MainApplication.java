package cn.orz.pascal.ssv;

import gueei.binding.Binder;
import android.app.Application;

/**
 * main application.
 *
 * @author koduki.
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Binder.init(this);
    }
}
