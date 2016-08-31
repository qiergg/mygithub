package com.clock.systemui.myfirstdemo;

import android.app.Application;
import android.content.Context;

import com.clock.systemui.myfirstdemo.hotfix.HotFixManger;
import com.clock.systemui.myfirstdemo.util.MAppManager;

/**
 * Created by maiya on 16/8/29.
 */
public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MAppManager.init(this);
        HotFixManger.init(this);




//        wwwissue2
        //issue3
//        ?\
    }
}
