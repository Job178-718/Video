package com.example.video;

import android.app.Application;
import android.content.Context;

/**
 * @author BoSun
 * @date 2021/10/20 22:05
 */
public class MyApplication extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
