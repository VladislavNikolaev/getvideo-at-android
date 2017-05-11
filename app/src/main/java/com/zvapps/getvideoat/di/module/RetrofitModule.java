package com.zvapps.getvideoat.di.module;

import android.support.annotation.NonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zvapps.getvideoat.BuildConfig;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module(includes = {NetworkModule.class, RestApiModule.class})
public class RetrofitModule {

    public static final String UNAUTHORIZED = "unauthorized";

    @NonNull
    private static Retrofit newRetrofit(@NonNull String baseUrl,
                                        @NonNull OkHttpClient client,
                                        @NonNull Converter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .validateEagerly(BuildConfig.DEBUG)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Named(UNAUTHORIZED)
    @Singleton
    @Provides
    Retrofit provideRetrofitUnauthorized(
            @Named(UNAUTHORIZED) @NonNull OkHttpClient client,
            @NonNull ObjectMapper mapper) {
        return newRetrofit(
                BuildConfig.API_BASE_URL, client, JacksonConverterFactory.create(mapper));
    }

    @Singleton
    @Provides
    public static ObjectMapper provideObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, BuildConfig.DEBUG)
                .setSerializationInclusion(JsonInclude.Include.ALWAYS)
                .registerModule(newJacksonAndroidModule());
    }

    private static SimpleModule newJacksonAndroidModule() {
        return new SimpleModule("Android");
    }

}
