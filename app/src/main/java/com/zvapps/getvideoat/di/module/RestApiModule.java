package com.zvapps.getvideoat.di.module;

import com.zvapps.getvideoat.data.newtwork.GetVideoApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module
public abstract class RestApiModule {

    @Reusable
    @Provides
    static GetVideoApi provideGetVideoApi(
            @Named(RetrofitModule.UNAUTHORIZED) Retrofit retrofit) {
        return retrofit.create(GetVideoApi.class);
    }

}
