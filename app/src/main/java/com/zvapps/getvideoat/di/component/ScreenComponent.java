package com.zvapps.getvideoat.di.component;

import com.zvapps.getvideoat.ui.main.MainActivity;
import com.zvapps.getvideoat.di.module.PresenterModule;
import com.zvapps.getvideoat.di.scope.ScreenScope;
import com.zvapps.getvideoat.ui.main.MainFragment;

import dagger.Subcomponent;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@ScreenScope
@Subcomponent(modules = {PresenterModule.class})
public interface ScreenComponent {

    void inject(MainActivity activity);

    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface Builder {

        ScreenComponent build();
    }
}
