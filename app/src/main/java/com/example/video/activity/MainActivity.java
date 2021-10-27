package com.example.video.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.video.BaseActivity;
import com.example.video.R;
import com.example.video.util.FromToPager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity {

    int initTime=3;

    private TextView timeText,textView ;

    private Timer time = new Timer();

    private Context context;

    public static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViewId();

        //获取上下文
        context=this;

        //线程内的内容，3秒后执行

        handler.postDelayed(new MyRunable(), 3100);

        //每隔一秒刷新一次
        new Thread(new TimeRunable()).start();
    }


    private void getViewId() {

        timeText = findViewById(R.id.timeText);

        textView = findViewById(R.id.jumpText);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FromToPager.toHomePager(context);
                finish();
                onDestroy();
            }
        });
    }


        class TimeRunable implements Runnable{

            @Override
            public void run() {
                Message message = new Message();
                message.what = 0;
                handler.sendMessage(message);
                if(initTime>0){
                    handler.postDelayed(new TimeRunable(),1000);
                }
            }
        }

        private Handler handler = new Handler(Looper.myLooper()) {

        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 0:
                    Log.e(TAG, "handleMessage: "+initTime);
                    timeText.setText(initTime + "s");
                    initTime--;
                    break;
                default:
                    break;
            }
        }
    };



    class MyRunable implements Runnable{

        @Override
        public void run() {
            if (context != null) {

                FromToPager.toHomePager(context);
                //跳转后销毁活动
                finish();
            }
        }
    }

}