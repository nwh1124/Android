package com.example.sbs.myapplication.ui;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.lifecycle.MutableLiveData;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.sbs.myapplication.util.Util;

public class BindingAdapters {
    @BindingConversion
    public static ColorDrawable convertLvColorToDrawable(MutableLiveData<Integer> color) {
        if (color == null) {
            return null;
        }

        return new ColorDrawable(color.getValue());
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        loadImage(imageView, imageUrl, 0);
    }

    @BindingAdapter({"imageUrl", "borderRadius"})
    public static void loadImage(ImageView imageView, String imageUrl, int borderRadius) {

        Util.log("imageUrl : " + imageUrl);

        RequestBuilder<Drawable> rb = Glide.with(imageView.getContext())
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

        if (borderRadius > 0) {
            rb.transform(new CenterCrop(), new RoundedCorners((int) Util.dipToPixels(borderRadius)));
        } else {
            rb.transform(new CenterCrop());
        }

        rb.into(imageView);
        //rb.placeholder(R.color.black).into(imageView);
    }
}
