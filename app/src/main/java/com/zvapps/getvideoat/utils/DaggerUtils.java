package com.zvapps.getvideoat.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.zvapps.getvideoat.GetVideoApp;
import com.zvapps.getvideoat.common.BaseActivity;
import com.zvapps.getvideoat.di.component.AppComponent;
import com.zvapps.getvideoat.di.component.ScreenComponent;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public final class DaggerUtils {

    @NonNull
    public static AppComponent getAppComponent(@NonNull Context context) {
        return ((GetVideoApp) context.getApplicationContext()).getAppComponent();
    }

    private DaggerUtils() {
    }

    public static ScreenComponent getScreenComponent(@NonNull Context context) {
        if (context instanceof BaseActivity) {
            return ((BaseActivity) context).getActivityComponent();
        } else {
            throw new IllegalArgumentException("Context must be BaseActivity");
        }
    }

    public static ScreenComponent newScreenComponent(@NonNull Context context) {
        return getAppComponent(context)
                .activityComponent()
                .build();
    }
}
