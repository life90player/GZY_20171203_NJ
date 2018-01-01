package com.example.greendaouse.GreenDaoPackage;

import android.database.sqlite.SQLiteDatabase;

import com.example.greendaouse.Base.MyApplication;
import com.example.greendaouse.GreenDaoPackage.com.example.greendaouse.DaoMaster;
import com.example.greendaouse.GreenDaoPackage.com.example.greendaouse.DaoSession;


public class GreenDaoUtils {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private static GreenDaoUtils greenDaoUtils;

    private GreenDaoUtils(){}

    public static GreenDaoUtils getSingleTon(){
        if (greenDaoUtils==null){
            greenDaoUtils=new GreenDaoUtils();
        }
        return greenDaoUtils;
    }

    private void initGreenDao(){
        MyApplication myApplication = new MyApplication();
        mHelper=new DaoMaster.DevOpenHelper(myApplication.getApplicationContext(),"test-db",null);
        db=mHelper.getWritableDatabase();
        mDaoMaster=new DaoMaster(db);
        mDaoSession=mDaoMaster.newSession();
    }

    public DaoSession getmDaoSession() {
        if (mDaoMaster==null){
            initGreenDao();
        }
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        if (db==null){
            initGreenDao();
        }
        return db;
    }

}
