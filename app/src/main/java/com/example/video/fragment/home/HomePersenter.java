package com.example.video.fragment.home;

import com.example.video.R;
import com.example.video.bean.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BoSun
 * @date 2021/10/23 21:43
 */
public class HomePersenter implements HomeContact.HomePersenter{

    private List<Video> videoList = new ArrayList<>();

    private HomeContact.HomeView homeView;

    public HomePersenter(HomeContact.HomeView view) {
        this.homeView = view;

    }

    @Override
    public void transfter() {
        homeView.showVideoView(getList());
    }

    public List<Video> getList(){
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
        videoList.add(new Video(R.mipmap.tupian,"123",1000));
       return  videoList;
    }


}
