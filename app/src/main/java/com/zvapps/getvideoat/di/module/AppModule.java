package com.zvapps.getvideoat.di.module;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.zvapps.getvideoat.di.component.ScreenComponent;
import com.zvapps.getvideoat.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module(subcomponents = {ScreenComponent.class})
public class AppModule {

    private final Application mApplication;

    public AppModule(@NonNull Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    Context provideApplicationContext() {
        return mApplication.getApplicationContext();
    }

    @Singleton
    @Provides
    static Cache provideDiskCache(@NonNull Application application) {
        return new Cache(application.getCacheDir(), Constants.HTTP_DISK_CACHE_SIZE);
    }
}