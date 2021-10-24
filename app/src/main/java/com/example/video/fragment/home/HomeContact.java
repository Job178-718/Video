package com.example.video.fragment.home;

import com.example.video.bean.Video;

import java.util.List;

/**
 * @author BoSun
 * @date 2021/10/23 21:37
 */
public interface HomeContact {
    interface HomeView{
        void showVideoView(List<Video> videoList);
    }
    interface HomePersenter{
        void transfter();
    }
    interface HomeModal{
        void initData();
    }
}
