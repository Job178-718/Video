package com.example.video.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.video.R;
import com.example.video.activity.VideoPlayerActivity;
import com.example.video.adapter.HomeAdapter;
import com.example.video.bean.Video;
import com.example.video.util.FromToPager;

import java.util.List;

public class HomeFragment extends Fragment implements HomeContact.HomeView {

    private RecyclerView recycler;

    private HomeAdapter homeAdapter;

    private HomeContact.HomePersenter homePersenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        homePersenter = new HomePersenter(this);
        homePersenter.transfter();
        return view;
    }


    @Override
    public void showVideoView(List<Video> videoList) {
        homeAdapter = new HomeAdapter(videoList);
        homeAdapter.setOnItemClickLitener(new HomeAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("HomeFragment", "onItemClick: "+position );
                FromToPager.toVideoPlayer(getContext());
            }
        });
        recycler.setAdapter(homeAdapter);
    }
}