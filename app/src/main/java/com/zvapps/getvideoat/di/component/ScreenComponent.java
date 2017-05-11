package com.zvapps.getvideoat.di.component;

import com.zvapps.getvideoat.MainActivity;
import com.zvapps.getvideoat.di.module.PresenterModule;
import com.zvapps.getvideoat.di.scope.ScreenScope;

import dagger.Subcomponent;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@ScreenScope
@Subcomponent(modules = {PresenterModule.class})
public interface ScreenComponent {

    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder {

        ScreenComponent build();
    }
}
