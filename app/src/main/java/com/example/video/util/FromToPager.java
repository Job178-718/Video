package com.example.video.util;


import android.content.Context;
import android.content.Intent;

import com.example.video.activity.HomeActivity;
import com.example.video.activity.VideoPlayerActivity;

public class FromToPager {

    /**
     * 跳转到主页
     * @param context
     */
    public static void toHomePager(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    public static void toVideoPlayer(Context context){
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        context.startActivity(intent);
    }


}
