package com.zvapps.getvideoat.ui.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zvapps.getvideoat.R;
import com.zvapps.getvideoat.ui.model.FormatVo;

/**
 * Created by Vladislav Nikolaev on 21.05.2017.
 */

public class DownloadVideoViewHolder {

    private final DownloadVideoItemBinging mBinding;

    static DownloadVideoViewHolder inflate(@NonNull LayoutInflater inflater,
                                           @Nullable ViewGroup parent) {
        DownloadVideoItemBinging binding = DataBindingUtil.inflate(
                inflater, R.layout.item_download_video, parent, false);
        return new DownloadVideoViewHolder(binding);
    }

    public DownloadVideoViewHolder(@NonNull DownloadVideoItemBinging binding) {
        mBinding = binding;
    }

    public void setFormat(@NonNull FormatVo format,
                          @NonNull DownloadLinksAdapter.Listener listener){
        mBinding.setFormat(format);
        mBinding.setListener(listener);
    }

    @NonNull
    public View getRoot(){
        return mBinding.getRoot();
    }
}
