package com.test.startandbindservicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnStartService;
    private Button btnStopService;
    private Intent intent;
    private Button btnBindService;
    private Button btnUnbindService;
    private MyServiceConnect mMyServiceConnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(MainActivity.this, MyTestService.class);
        init();

        initView();
        setBtnStartService();
        setBtnStopService();
        setBtnBindService();
        setBtnUnbindService();
    }

    /**
     * 初始化 ServiceConnection
     */
    private void init(){
        mMyServiceConnect = new MyServiceConnect();
    }

    /**
     * 初始化按钮
     */
    public void initView(){
        btnStartService = (Button) MainActivity.this.findViewById(R.id.btn_startService);
        btnStopService = (Button) MainActivity.this.findViewById(R.id.btn_stopService);
        btnBindService = (Button) MainActivity.this.findViewById(R.id.btn_bind_service);
        btnUnbindService = (Button) MainActivity.this.findViewById(R.id.btn_unbind_service);
    }

    private void setBtnStartService(){
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
    }

    private void setBtnStopService(){
        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }

    private void setBtnBindService(){
        btnBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindService(intent, mMyServiceConnect, BIND_AUTO_CREATE);
            }
        });
    }

    public void setBtnUnbindService() {
        btnUnbindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(mMyServiceConnect);
            }
        });
    }

    private class MyServiceConnect implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("Bind方式成功连接服务", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("Bind方式断开连接服务", "onServiceConnected");
        }
    }
}
