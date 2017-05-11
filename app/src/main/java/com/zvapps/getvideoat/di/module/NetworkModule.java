package com.zvapps.getvideoat.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.github.simonpercic.oklog3.OkLogInterceptor;
import com.zvapps.getvideoat.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import static com.zvapps.getvideoat.di.module.RetrofitModule.UNAUTHORIZED;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module
public abstract class NetworkModule {

    private static OkHttpClient.Builder newBaseOkHttpClient(
            @NonNull Cache cache,
            @NonNull OkLogInterceptor okLogInterceptor,
            @NonNull StethoInterceptor stethoInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(okLogInterceptor)
                .addNetworkInterceptor(stethoInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .cache(cache);
    }

    @Singleton
    @Named(UNAUTHORIZED)
    @Provides
    static OkHttpClient provideUnauthorizedOkHttpClient(
            @NonNull Context context,
            @NonNull Cache cache,
            @NonNull OkLogInterceptor okLogInterceptor,
            @NonNull StethoInterceptor stethoInterceptor) {
        return newBaseOkHttpClient(cache, okLogInterceptor, stethoInterceptor)
                .build();
    }

    @Singleton
    @Provides
    static OkLogInterceptor newOkLogInterceptor() {
        return OkLogInterceptor.builder()
                .useAndroidLog(false)
                .withRequestHeaders(BuildConfig.OKLOG_HEADERS)
                .withResponseHeaders(BuildConfig.OKLOG_HEADERS)
                .build();
    }

    @Singleton
    @Provides
    static StethoInterceptor provideStethoInterceptor(@NonNull Context context) {
        Stetho.initialize(
                Stetho.newInitializerBuilder(context)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
                        .build());
        return new StethoInterceptor();
    }
}
