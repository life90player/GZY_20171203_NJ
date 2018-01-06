package com.example.greendao.Base;

import android.app.Application;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class GApplication extends Application
{
    private static GApplication mInstance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance = this;
    }

    public static GApplication getInstance()
    {
        return mInstance;
    }


}
