package com.zvapps.getvideoat.ui.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.zvapps.getvideoat.R;
import com.zvapps.getvideoat.ui.model.FormatVo;

import java.util.List;
import java.util.Objects;

/**
 * Created by Vladislav Nikolaev on 21.05.2017.
 */

public class DownloadLinksAdapter extends ArrayAdapter<FormatVo> {

    @NonNull
    private final Listener mListener;

    public DownloadLinksAdapter(@NonNull Context context,
                                @NonNull List<FormatVo> items,
                                @NonNull Listener listener) {
        super(context, R.layout.item_download_video, items);
        mListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DownloadVideoViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            viewHolder = DownloadVideoViewHolder.inflate(inflater, parent);
            convertView = viewHolder.getRoot();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (DownloadVideoViewHolder) convertView.getTag();
        }

        FormatVo item = getItem(position);
        viewHolder.setFormat(Objects.requireNonNull(item), mListener);

        return convertView;
    }

    public interface Listener {

        void onDownloadVideoItemClick(@NonNull FormatVo formatVo);
    }
}
