package com.zvapps.getvideoat.di.module;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module
public class RxModule {

    public static final String SCHEDULER_UI = "observe";
    public static final String SCHEDULER_IO = "io";
    public static final String SCHEDULER_COMPUTATION = "computation";

    @Provides
    @Named(SCHEDULER_UI)
    @Singleton
    public static Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Named(SCHEDULER_IO)
    @Singleton
    public static Scheduler provideNetworkScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Named(SCHEDULER_COMPUTATION)
    @Singleton
    public static Scheduler provideAsyncScheduler() {
        return Schedulers.computation();
    }
}
