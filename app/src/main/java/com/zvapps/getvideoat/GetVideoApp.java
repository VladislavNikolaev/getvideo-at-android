package com.zvapps.getvideoat;

import android.app.Application;

import com.zvapps.getvideoat.di.component.AppComponent;
import com.zvapps.getvideoat.di.component.DaggerAppComponent;
import com.zvapps.getvideoat.di.module.AppModule;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

public class GetVideoApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
