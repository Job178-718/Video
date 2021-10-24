package com.example.video.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.video.BaseActivity;
import com.example.video.R;
import com.example.video.util.FromToPager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {


    private TextView timeText;
    private Timer time = new Timer();
    int initTime=3;
    private Context context;

    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewId();

        //获取上下文
        context=this;

        //3秒后自动进入程序
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (context != null) {
                    //TODO:先加载数据;
                    FromToPager.toHomePager(context);
                    //跳转后销毁活动
                    finish();
                }

            }
        }, 3100);
    }


    private void getViewId() {

        timeText = findViewById(R.id.timeText);
        //每隔一秒修改显示倒计时time.schedule()第二个参数代表页面活动
        //完全激活后多少*1000秒开始倒计时


        //实现改变UI倒计时;
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                //线程不能直接对UI处理；
                Message message = new Message();
                message.what = 1;
                //2.相当于handler
                handler.sendMessage(message);
            }
        }, 0, 3000);

    }



    private Handler handler = new Handler(Looper.myLooper()) {

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    timeText.setText(initTime + "s");
                    initTime--;
                    break;
                default:
                    break;
            }
        }
    };




}