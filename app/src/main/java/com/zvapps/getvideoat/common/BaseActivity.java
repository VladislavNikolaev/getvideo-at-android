package com.zvapps.getvideoat.common;

import android.support.v7.app.AppCompatActivity;

import com.zvapps.getvideoat.di.component.ScreenComponent;
import com.zvapps.getvideoat.utils.DaggerUtils;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public class BaseActivity extends AppCompatActivity {

    public ScreenComponent getActivityComponent() {
        if (getLastNonConfigurationInstance() instanceof ScreenComponent) {
            return (ScreenComponent) getLastNonConfigurationInstance();
        } else {
            return DaggerUtils.newScreenComponent(this);
        }
    }
}
