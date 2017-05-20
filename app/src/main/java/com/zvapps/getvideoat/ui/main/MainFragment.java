package com.zvapps.getvideoat.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateFragment;
import com.zvapps.getvideoat.ui.model.VideoLinksVo;
import com.zvapps.getvideoat.utils.DaggerUtils;

import javax.inject.Inject;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public class MainFragment
        extends MvpViewStateFragment<MainMvp.View, MainMvp.Presenter, MainViewState>
        implements MainMvp.View {

    @Inject
    MainMvp.Presenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerUtils.getScreenComponent(getContext()).inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url = "https://www.youtube.com/watch?v=X1RVYt2QKQE";
        mPresenter.requestVideoLinksByUrl(url);
    }

    @NonNull
    @Override
    public MainMvp.Presenter createPresenter() {
        return mPresenter;
    }

    @NonNull
    @Override
    public MainViewState createViewState() {
        return new MainViewState();
    }

    @Override
    public void onNewViewStateInstance() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showVideoUrlForm() {

    }

    @Override
    public void showVideoUrls(@NonNull VideoLinksVo videoLinksVo) {

    }
}
