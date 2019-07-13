package com.insightsurfface.stylelibrary.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.insightsurfface.stylelibrary.R;

public class English9KeyboardView extends RelativeLayout {
    private Context mContext;
    public English9KeyboardView(Context context) {
        this(context,null);
    }

    public English9KeyboardView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public English9KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        init();
    }

    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.keyboard_english9, this);
    }
}
