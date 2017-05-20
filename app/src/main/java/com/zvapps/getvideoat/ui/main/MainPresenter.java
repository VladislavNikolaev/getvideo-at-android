package com.zvapps.getvideoat.ui.main;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.zvapps.getvideoat.data.newtwork.GetVideoApiHelper;
import com.zvapps.getvideoat.di.module.RxModule;
import com.zvapps.getvideoat.di.scope.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

@ScreenScope
public class MainPresenter extends MvpBasePresenter<MainMvp.View> implements MainMvp.Presenter {

    private final GetVideoApiHelper mGetVideoApi;
    private Scheduler mSubscribeOn;
    private Scheduler mObserveOn;

    @Inject
    MainPresenter(@NonNull GetVideoApiHelper getVideoApi,
                  @NonNull @Named(RxModule.SCHEDULER_IO) Scheduler subscribeOn,
                  @NonNull @Named(RxModule.SCHEDULER_UI) Scheduler observeOn) {
        mGetVideoApi = getVideoApi;
        mSubscribeOn = subscribeOn;
        mObserveOn = observeOn;
    }

    @Override
    public void requestVideoLinksByUrl(@NonNull String url) {
        mGetVideoApi.getVideoLinks(url)
                .subscribeOn(mSubscribeOn)
                .observeOn(mObserveOn)
                .doOnError(error -> getView().showError())
                .subscribe(getView()::showVideoUrls);
    }
}
