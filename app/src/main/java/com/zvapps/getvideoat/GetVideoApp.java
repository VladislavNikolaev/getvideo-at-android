package com.zvapps.getvideoat;

import android.app.Application;

import com.zvapps.getvideoat.di.component.DaggerAppComponent;
import com.zvapps.getvideoat.di.module.AppModule;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public class GetVideoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
