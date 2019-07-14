package com.insightsurfface.stylelibrary.keyboard;

import android.content.Context;

import com.insightsurfface.stylelibrary.configue.ShareKeys;
import com.insightsurfface.stylelibrary.utils.SharedPreferencesUtils;

public class KeyboardSettings {
    public static void closeVibration(Context context) {
        SharedPreferencesUtils.setSharedPreferencesData
                (context, ShareKeys.CLOSE_SH_KEYBOARD_VIBRATION, true);
    }

    public static void setAnotherOrder(Context context, boolean other) {
        SharedPreferencesUtils.setSharedPreferencesData
                (context, ShareKeys.IS_OTHER_LETTER_ORDER, other);
    }
}
