package com.example.alphonso.alphonso2017summer;

import android.app.Application;

import com.example.alphonso.alphonso2017summer.util.UtilLog;

/**
 * Created by Alphonso on 6/20/2017.
 */

public class AlphonsoApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setIsLog(true);
    }
}
