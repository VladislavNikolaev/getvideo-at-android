package com.zvapps.getvideoat.utils.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import timber.log.Timber;

/**
 * Created by Vladislav Nikolaev on 21.05.2017.
 */

public class ImageDataBindingAdapters {

    @BindingAdapter(
            value = {"imageUrl", "imageError", "placeholder"},
            requireAll = false)
    public static void loadImage(@NonNull ImageView imageView,
                                 @Nullable String url,
                                 @Nullable Drawable errorImage,
                                 @Nullable Drawable placeholder) {
        Uri uri = url == null ? null : Uri.parse(url);
        if (uri == null) {
            imageView.setImageDrawable(placeholder);
            return;
        }

        Glide.with(imageView.getContext())
                .load(uri)
                .asBitmap()
                .animate(android.R.anim.fade_in)
                .error(errorImage)
                .placeholder(placeholder)
                .fallback(errorImage)
                .listener(new RequestListener<Uri, Bitmap>() {
                    @Override
                    public boolean onException(Exception e,
                                               Uri model,
                                               Target<Bitmap> target,
                                               boolean isFirstResource) {
                        Timber.e(e, " onException ");
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource,
                                                   Uri model,
                                                   Target<Bitmap> target,
                                                   boolean isFromMemoryCache,
                                                   boolean isFirstResource) {
                        Timber.d(" onResourceReady %s", url);
                        return false;
                    }
                })
                .into(imageView);
    }
}
