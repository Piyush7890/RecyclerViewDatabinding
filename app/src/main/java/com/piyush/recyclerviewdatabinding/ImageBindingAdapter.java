package com.piyush.recyclerviewdatabinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageBindingAdapter {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
