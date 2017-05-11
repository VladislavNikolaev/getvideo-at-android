package com.zvapps.getvideoat.data.newtwork;

import android.support.annotation.NonNull;

import com.zvapps.getvideoat.ui.model.VideoLinksVo;
import com.zvapps.getvideoat.utils.Mapper;

import javax.inject.Inject;

import dagger.Reusable;
import io.reactivex.Single;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Reusable
public class GetVideoApiHelper {

    private GetVideoApi mGetVideoApi;

    @Inject
    GetVideoApiHelper(@NonNull GetVideoApi getVideoApi) {
        mGetVideoApi = getVideoApi;
    }

    public Single<VideoLinksVo> getVideoLinks(@NonNull String sourceVideoUrl) {
        return mGetVideoApi.getVideoLinks(sourceVideoUrl)
                .map(Mapper::toVideoLinksVo);
    }
}
