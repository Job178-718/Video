package com.example.video.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.video.R;
import com.example.video.bean.Video;

import java.util.List;

/**
 * @author BoSun
 * @date 2021/10/23 21:23
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH> {

    private List<Video> videoList;

    private OnItemClickLitener mOnItemClickLitener;

    class VH extends RecyclerView.ViewHolder{

        ImageView homeImage;

        TextView homeText;

        TextView timeText;


        public VH(@NonNull View itemView) {
            super(itemView);
            homeImage= itemView.findViewById(R.id.image);
            homeText = itemView.findViewById(R.id.text);
            timeText = itemView.findViewById(R.id.longTime);
        }
    }

    public HomeAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }


    //设置回调接口
    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modal_recycler_home, parent, false);
        VH vh = new VH(view);
        return vh;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Video video = videoList.get(position);
        holder.homeImage.setImageResource(video.getId());
        holder.homeText.setText(video.getVideoName());
        holder.timeText.setText(video.getVideoTime()+"");

        if(mOnItemClickLitener!=null){
            holder.homeImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }


}
