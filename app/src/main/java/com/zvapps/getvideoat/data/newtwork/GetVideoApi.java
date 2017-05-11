package com.zvapps.getvideoat.data.newtwork;

import android.support.annotation.NonNull;

import com.zvapps.getvideoat.data.model.VideoLinksDto;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public interface GetVideoApi {

    @GET("search")
    Single<VideoLinksDto> getVideoLinks(@Query("q") @NonNull String videoSourceUrl);

}
