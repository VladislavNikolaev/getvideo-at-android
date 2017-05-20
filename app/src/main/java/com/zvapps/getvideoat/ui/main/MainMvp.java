package com.zvapps.getvideoat.ui.main;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.zvapps.getvideoat.ui.model.VideoLinksVo;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public class MainMvp {

    public interface View extends MvpView {

        void showLoading();

        void showError();

        void showVideoUrlForm();

        void showVideoUrls(@NonNull VideoLinksVo videoLinksVo);
    }

    public interface Presenter extends MvpPresenter<View> {

        void requestVideoLinksByUrl(@NonNull String url);
    }
}
