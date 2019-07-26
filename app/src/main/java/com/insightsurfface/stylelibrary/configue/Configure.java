package com.insightsurfface.stylelibrary.configue;

import android.graphics.Bitmap;

import com.insightsurfface.stylelibrary.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

public class Configure {
    public static final DisplayImageOptions defaultDisplayImgOptions = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .showImageOnLoading(R.drawable.ic_loading)
            .showImageOnFail(R.drawable.ic_failed)
            .build();
}
