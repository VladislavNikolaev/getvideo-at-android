package com.zvapps.getvideoat.ui.main;

import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public class MainViewState implements ViewState<MainMvp.View> {

    final int STATE_SHOW_VIDEO_URL_FORM = 0;
    final int STATE_SHOW_LOADING = 1;
    final int STATE_SHOW_ERROR = 2;

    int state = STATE_SHOW_VIDEO_URL_FORM;

    public void setShowVideolUrlForm() {
        state = STATE_SHOW_VIDEO_URL_FORM;
    }

    public void setShowError() {
        state = STATE_SHOW_ERROR;
    }

    public void setShowLoading() {
        state = STATE_SHOW_LOADING;
    }

    @Override
    public void apply(MainMvp.View view, boolean retained) {
        switch (state) {
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;

            case STATE_SHOW_ERROR:
                view.showError();
                break;

            case STATE_SHOW_VIDEO_URL_FORM:
                view.showVideoUrlForm();
                break;
        }
    }
}
