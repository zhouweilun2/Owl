package com.web.web_spingboot.entity;

public class VideoMessage {
    private String videoData;

    public VideoMessage() {
        // Default constructor for deserialization
    }

    public VideoMessage(String videoData) {
        this.videoData = videoData;
    }

    public String getVideoData() {
        return videoData;
    }

    public void setVideoData(String videoData) {
        this.videoData = videoData;
    }
}
