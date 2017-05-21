package com.zvapps.getvideoat.ui.model;

import android.support.annotation.NonNull;

/**
 * Created by Vladislav Nikolaev on 21.05.2017.
 */

public class FormatVo {

    private final String mUrl;

    private final String mQuality;

    private final String mFormat;

    private final String mFilename;

    public FormatVo(@NonNull String url,
                    @NonNull String quality,
                    @NonNull String format,
                    @NonNull String filename) {
        mUrl = url;
        mQuality = quality;
        mFormat = format;
        mFilename = filename;
    }

    @NonNull
    public String getUrl() {
        return mUrl;
    }

    @NonNull
    public String getQuality() {
        return mQuality;
    }

    @NonNull
    public String getFormat() {
        return mFormat;
    }

    @NonNull
    public String getFilename() {
        return mFilename;
    }
}
