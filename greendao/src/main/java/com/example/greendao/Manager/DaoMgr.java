package com.example.greendao.Manager;

import com.example.greendao.Base.GApplication;
import org.gzy.greendao.DaoMaster;
import org.gzy.greendao.DaoSession;

/**
 * Created by Administrator on 2018/1/6 0006.
 */

public class DaoMgr
{
    private static DaoMgr mInstance;
    private DaoSession mDSion;

    private DaoMgr()
    {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(GApplication.getInstance(),"VideoMetaTable");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDSion = daoMaster.newSession();
    }

    public static DaoMgr getInstance()
    {
        if (null == mInstance)
        {
            mInstance = new DaoMgr();
        }
        return mInstance;
    }

    public DaoSession getmDSion()
    {
          return mDSion;
    }
}
