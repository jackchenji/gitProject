package greendao;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import greendao.entity.DaoMaster;
import greendao.entity.DaoSession;

/*
 *Created by chenji on 2019/8/5
 */ public class DaoSessionManager {
    private final String DB_NAME = "androids.db";
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private static DaoMaster.DevOpenHelper mHelper;


    private DaoSessionManager() {
    }

    public static DaoSessionManager mInstance = new DaoSessionManager();

    public static DaoSessionManager getInstace() {

        return mInstance;
    }

    public DaoMaster getDaoMaster(Context mContext) {

        mHelper = new DaoMaster
                .DevOpenHelper(mContext, DB_NAME, null);
        daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        return daoMaster;
    }

    public DaoSession getDaoSession(Context mContext) {

        if (daoSession == null) {

            if (daoMaster == null) {
                getDaoMaster(mContext);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }


    /**
     * 设置debug模式开启或关闭，默认关闭
     */
    public void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }


    /*关闭daoSession*/
    public void closeDaoSession() {
        if (null != daoSession) {
            daoSession.clear();
            daoSession = null;
        }
    }
    /*关闭Helper*/
    public void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }

}
