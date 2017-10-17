package com.test.startandbindservicetest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by null on 17-10-14.
 * 
 */

public class MyTestService extends Service {
    private Notification.Builder builder;
    private NotificationManager notificationManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("测试Bind方式启动Servier", "----onBind----");
        return new MyIBinder();
    }

    class MyIBinder extends Binder {
        public MyTestService getService() {
            return MyTestService.this;
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("测试Bind方式启动Servier", "----onUnbind----");
        return false;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("测试Bind方式启动Servier", "----onRebind----");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //获得系统的通知管理者
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Log.d("测试Bind方式启动Servier", "----onCreate----");

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("测试Start方式启动Servier", "----onStartCommand---- id: " + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("测试Bind方式启动Servier", "----onDestroy----");
    }
}
