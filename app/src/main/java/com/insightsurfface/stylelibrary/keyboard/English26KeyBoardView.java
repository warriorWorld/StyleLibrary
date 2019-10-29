package com.insightsurfface.stylelibrary.keyboard;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.insightsurfface.stylelibrary.R;
import com.insightsurfface.stylelibrary.configue.ShareKeys;
import com.insightsurfface.stylelibrary.listener.OnKeyboardChangeListener;
import com.insightsurfface.stylelibrary.listener.OnKeyboardListener;
import com.insightsurfface.stylelibrary.utils.SharedPreferencesUtils;
import com.insightsurfface.stylelibrary.utils.VibratorUtil;

import java.lang.reflect.Method;


public class English26KeyBoardView extends RelativeLayout implements View.OnClickListener {
    private Context context;
    private Button qBtn;
    private Button wBtn;
    private Button eBtn;
    private Button rBtn;
    private Button tBtn;
    private Button yBtn;
    private Button uBtn;
    private Button iBtn;
    private Button oBtn;
    private Button pBtn;
    private ImageView closeBtn;
    private Button aBtn;
    private Button sBtn;
    private Button dBtn;
    private Button fBtn;
    private Button gBtn;
    private Button hBtn;
    private Button jBtn;
    private Button kBtn;
    private Button lBtn;
    private ImageView deleteBtn;
    private ImageView spaceBtn;
    private Button zBtn;
    private Button xBtn;
    private Button cBtn;
    private Button vBtn;
    private Button bBtn;
    private Button nBtn;
    private Button mBtn;
    private ImageView enterBtn;
    private EditText mEditText;
    private KeyBorad26Listener mKeyBorad26Listener;

    public English26KeyBoardView(Context context) {
        this(context, null);
    }

    public English26KeyBoardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public English26KeyBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    protected void init() {
        LayoutInflater.from(context).inflate(R.layout.keyboard_english26, this);
        qBtn = (Button) findViewById(R.id.q_btn);
        wBtn = (Button) findViewById(R.id.w_btn);
        eBtn = (Button) findViewById(R.id.e_btn);
        rBtn = (Button) findViewById(R.id.r_btn);
        tBtn = (Button) findViewById(R.id.t_btn);
        yBtn = (Button) findViewById(R.id.y_btn);
        uBtn = (Button) findViewById(R.id.u_btn);
        iBtn = (Button) findViewById(R.id.i_btn);
        oBtn = (Button) findViewById(R.id.o_btn);
        pBtn = (Button) findViewById(R.id.p_btn);
        closeBtn = (ImageView) findViewById(R.id.close_btn);
        aBtn = (Button) findViewById(R.id.a_btn);
        sBtn = (Button) findViewById(R.id.s_btn);
        dBtn = (Button) findViewById(R.id.d_btn);
        fBtn = (Button) findViewById(R.id.f_btn);
        gBtn = (Button) findViewById(R.id.g_btn);
        hBtn = (Button) findViewById(R.id.h_btn);
        jBtn = (Button) findViewById(R.id.j_btn);
        kBtn = (Button) findViewById(R.id.k_btn);
        lBtn = (Button) findViewById(R.id.l_btn);
        deleteBtn = (ImageView) findViewById(R.id.delete_btn);
        spaceBtn = (ImageView) findViewById(R.id.space_btn);
        zBtn = (Button) findViewById(R.id.z_btn);
        xBtn = (Button) findViewById(R.id.x_btn);
        cBtn = (Button) findViewById(R.id.c_btn);
        vBtn = (Button) findViewById(R.id.v_btn);
        bBtn = (Button) findViewById(R.id.b_btn);
        nBtn = (Button) findViewById(R.id.n_btn);
        mBtn = (Button) findViewById(R.id.m_btn);
        enterBtn = (ImageView) findViewById(R.id.enter_btn);

        qBtn.setOnClickListener(this);
        wBtn.setOnClickListener(this);
        eBtn.setOnClickListener(this);
        rBtn.setOnClickListener(this);
        tBtn.setOnClickListener(this);
        yBtn.setOnClickListener(this);
        uBtn.setOnClickListener(this);
        iBtn.setOnClickListener(this);
        oBtn.setOnClickListener(this);
        pBtn.setOnClickListener(this);
        aBtn.setOnClickListener(this);
        sBtn.setOnClickListener(this);
        dBtn.setOnClickListener(this);
        fBtn.setOnClickListener(this);
        gBtn.setOnClickListener(this);
        hBtn.setOnClickListener(this);
        jBtn.setOnClickListener(this);
        kBtn.setOnClickListener(this);
        lBtn.setOnClickListener(this);
        zBtn.setOnClickListener(this);
        xBtn.setOnClickListener(this);
        cBtn.setOnClickListener(this);
        vBtn.setOnClickListener(this);
        bBtn.setOnClickListener(this);
        nBtn.setOnClickListener(this);
        mBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);
        spaceBtn.setOnClickListener(this);
        deleteBtn.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                delete(true);
                return true;
            }
        });
    }

    /**
     * edittext绑定自定义键盘
     *
     * @param editText 需要绑定自定义键盘的edittext
     */
    public void attachTo(EditText editText) {
        this.mEditText = editText;
        hideSystemSofeKeyboard(context.getApplicationContext(), mEditText);
    }

    public void show() {
        this.setVisibility(VISIBLE);
    }

    public void hide() {
        this.setVisibility(GONE);
    }

    protected void onOkBtnClick() {
        if (null != mKeyBorad26Listener) {
            mKeyBorad26Listener.inputFinish(mEditText.getText().toString());
        }
    }

    @Override
    public void onClick(View v) {
        VibratorUtil.Vibrate(context,20);
        if (v == qBtn) {
            // Handle clicks for qBtn
            handleInsert("q");
        } else if (v == wBtn) {
            // Handle clicks for wBtn
            handleInsert("w");
        } else if (v == eBtn) {
            // Handle clicks for eBtn
            handleInsert("e");
        } else if (v == rBtn) {
            // Handle clicks for rBtn
            handleInsert("r");
        } else if (v == tBtn) {
            // Handle clicks for tBtn
            handleInsert("t");
        } else if (v == yBtn) {
            // Handle clicks for yBtn
            handleInsert("y");
        } else if (v == uBtn) {
            // Handle clicks for uBtn
            handleInsert("u");
        } else if (v == iBtn) {
            // Handle clicks for iBtn
            handleInsert("i");
        } else if (v == oBtn) {
            // Handle clicks for oBtn
            handleInsert("o");
        } else if (v == pBtn) {
            // Handle clicks for pBtn
            handleInsert("p");
        } else if (v == aBtn) {
            // Handle clicks for aBtn
            handleInsert("a");
        } else if (v == sBtn) {
            // Handle clicks for sBtn
            handleInsert("s");
        } else if (v == dBtn) {
            // Handle clicks for dBtn
            handleInsert("d");
        } else if (v == fBtn) {
            // Handle clicks for fBtn
            handleInsert("f");
        } else if (v == gBtn) {
            // Handle clicks for gBtn
            handleInsert("g");
        } else if (v == hBtn) {
            // Handle clicks for hBtn
            handleInsert("h");
        } else if (v == jBtn) {
            // Handle clicks for jBtn
            handleInsert("j");
        } else if (v == kBtn) {
            // Handle clicks for kBtn
            handleInsert("k");
        } else if (v == lBtn) {
            // Handle clicks for lBtn
            handleInsert("l");
        } else if (v == zBtn) {
            // Handle clicks for zBtn
            handleInsert("z");
        } else if (v == xBtn) {
            // Handle clicks for xBtn
            handleInsert("x");
        } else if (v == cBtn) {
            // Handle clicks for cBtn
            handleInsert("c");
        } else if (v == vBtn) {
            // Handle clicks for vBtn
            handleInsert("v");
        } else if (v == bBtn) {
            // Handle clicks for bBtn
            handleInsert("b");
        } else if (v == nBtn) {
            // Handle clicks for nBtn
            handleInsert("n");
        } else if (v == mBtn) {
            // Handle clicks for mBtn
            handleInsert("m");
        } else if (v == deleteBtn) {
            delete(false);
        } else if (v == enterBtn) {
            onOkBtnClick();
        } else if (v == spaceBtn) {
            handleInsert(" ");
        } else if (v == closeBtn) {
            if (null!=mKeyBorad26Listener){
                mKeyBorad26Listener.closeKeyboard();
            }
        }
    }

    private void delete(boolean delteAll) {
        Editable editable = mEditText.getText();
        int start = mEditText.getSelectionStart();
        int end = mEditText.getSelectionEnd();
        if (end > start) {
            editable.delete(start, end);
        }
        if (!TextUtils.isEmpty(editable)) {
            if (start > 0) {
                if (delteAll) {
                    editable.delete(0, start);
                } else {
                    editable.delete(start - 1, start);
                }
            }
        }
    }

    private void handleInsert(String s) {
        Editable editable = mEditText.getText();
        int start = mEditText.getSelectionStart();
        int end = mEditText.getSelectionEnd();
        if (end > start) {
            editable.delete(start, end);
        }
        editable.insert(start, s);
    }

    /**
     * 隐藏系统键盘
     *
     * @param editText
     */
    public static void hideSystemSofeKeyboard(Context context, EditText editText) {
        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= 11) {
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);

            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            editText.setInputType(InputType.TYPE_NULL);
        }
        // 如果软键盘已经显示，则隐藏
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void setKeyBorad26Listener(KeyBorad26Listener keyBorad26Listener) {
        mKeyBorad26Listener = keyBorad26Listener;
    }

    public interface KeyBorad26Listener {
        void inputFinish(String s);

        void closeKeyboard();
    }
}
