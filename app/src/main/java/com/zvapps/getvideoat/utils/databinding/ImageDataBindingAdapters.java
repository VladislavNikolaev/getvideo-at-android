package com.zvapps.getvideoat.utils.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;

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
                .into(imageView);
    }
}
