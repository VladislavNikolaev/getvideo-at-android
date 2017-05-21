package com.zvapps.getvideoat.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.github.simonpercic.oklog3.OkLogInterceptor;
import com.zvapps.getvideoat.BuildConfig;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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
        return getUnsafeOkHttpClientBuilder()
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

    private static OkHttpClient.Builder getUnsafeOkHttpClientBuilder() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                                       String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                                       String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            return new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier((hostname, session) -> true);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
