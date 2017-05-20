package com.zvapps.getvideoat.di.module;

import com.zvapps.getvideoat.ui.main.MainMvp;
import com.zvapps.getvideoat.ui.main.MainPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Vladislav Nikolaev on 11.05.2017.
 */

@Module
public abstract class PresenterBindingModule {

    @Binds
    abstract MainMvp.Presenter bindMainPresenter(MainPresenter presenter);
}
