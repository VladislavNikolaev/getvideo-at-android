package com.zvapps.getvideoat.ui.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateFragment;
import com.zvapps.getvideoat.R;
import com.zvapps.getvideoat.ui.model.FormatVo;
import com.zvapps.getvideoat.ui.model.VideoLinksVo;
import com.zvapps.getvideoat.utils.DaggerUtils;

import java.util.Objects;

import javax.inject.Inject;

/**
 * Created by Vladislav Nikolaev on 20.05.2017.
 */

public class MainFragment
        extends MvpViewStateFragment<MainMvp.View, MainMvp.Presenter, MainViewState>
        implements MainMvp.View, DownloadLinksAdapter.Listener {

    @Inject
    MainMvp.Presenter mPresenter;
    private MainFragmentDataBinding mBinding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerUtils.getScreenComponent(getContext()).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        //TODO: add progress view
    }

    @Override
    public void showError() {
        //TODO: add errors handling
    }

    @Override
    public void showVideoUrlForm() {
        //TODO: add video url form
    }

    @Override
    public void showVideoUrls(@NonNull VideoLinksVo videoLinksVo) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        Objects.requireNonNull(actionBar).setTitle(videoLinksVo.getTitle());
        mBinding.setVideoLinks(videoLinksVo);
        DownloadLinksAdapter adapter =
                new DownloadLinksAdapter(getContext(), videoLinksVo.getVideoFormats(), this);
        mBinding.downloadLinksList.setAdapter(adapter);
    }

    @Override
    public void onDownloadVideoItemClick(@NonNull FormatVo formatVo) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(formatVo.getUrl()));
        startActivity(browserIntent);
    }
}
