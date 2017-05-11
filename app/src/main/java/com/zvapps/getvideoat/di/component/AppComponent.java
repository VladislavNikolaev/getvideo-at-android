package com.zvapps.getvideoat.di.component;

import com.zvapps.getvideoat.GetVideoApp;
import com.zvapps.getvideoat.di.module.AppModule;
import com.zvapps.getvideoat.di.module.RetrofitModule;
import com.zvapps.getvideoat.di.module.RxModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        RetrofitModule.class,
        RxModule.class
})
public interface AppComponent {

    ScreenComponent.Builder activityComponent();

    void inject(GetVideoApp app);
}
