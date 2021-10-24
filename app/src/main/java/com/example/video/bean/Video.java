package com.example.video.bean;

/**
 * @author BoSun
 * @date 2021/10/23 21:20
 */
public class Video {
    private int id;
    private String videoName;
    private long videoTime;

    public Video(int id, String videoName, long videoTime) {
        this.id = id;
        this.videoName = videoName;
        this.videoTime = videoTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public long getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(long videoTime) {
        this.videoTime = videoTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", videoTime=" + videoTime +
                '}';
    }
}
