package com.zvapps.getvideoat.ui.model;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public class VideoLinksVo {

    private final String mSourceVideoUrl;

    private String mDuration;

    private String mThumbnail;

    private List<FormatVo> mAudioFormats;

    private List<FormatVo> mVideoFormats;

    private String mTitle;

    public VideoLinksVo(@NonNull String sourceVideoUrl) {
        mSourceVideoUrl = sourceVideoUrl;
    }

    @NonNull
    public String getSourceVideoUrl() {
        return mSourceVideoUrl;
    }

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public List<FormatVo> getAudioFormats() {
        return mAudioFormats;
    }

    public void setAudioFormats(List<FormatVo> audioFormats) {
        mAudioFormats = audioFormats;
    }

    public List<FormatVo> getVideoFormats() {
        return mVideoFormats;
    }

    public void setVideoFormats(List<FormatVo> videoFormats) {
        mVideoFormats = videoFormats;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
