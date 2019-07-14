package com.insightsurfface.stylelibrary.keyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.insightsurfface.stylelibrary.R;
import com.insightsurfface.stylelibrary.configue.ShareKeys;
import com.insightsurfface.stylelibrary.listener.OnKeyboardChangeListener;
import com.insightsurfface.stylelibrary.listener.OnKeyboardListener;
import com.insightsurfface.stylelibrary.utils.SharedPreferencesUtils;

import java.lang.reflect.Method;


public class English9KeyBoardView extends RelativeLayout implements View.OnClickListener, GestureButton.OnResultListener {
    private Context context;
    private GestureButton abcGb;
    private GestureButton defGb;
    private GestureButton ghiGb;
    private GestureButton jklGb;
    private GestureButton mnoGb;
    private GestureButton pqrsGb;
    private GestureButton tuvGb;
    private GestureButton wxyzGb;
    private View deleteBtn;
    private View spaceBtn;
    private View okBtn;
    private View helpBtn;
    private View optionsBtn;
    protected OnKeyboardChangeListener mOnKeyboardChangeListener;
    private OnKeyboardListener mOnKeyboardListener;
    private EditText mEditText;

    public English9KeyBoardView(Context context) {
        this(context, null);
    }

    public English9KeyBoardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public English9KeyBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    protected void init() {
        LayoutInflater.from(context).inflate(R.layout.keyboard_english9, this);
        abcGb = (GestureButton) findViewById(R.id.abc_gb);
        defGb = (GestureButton) findViewById(R.id.def_gb);
        ghiGb = (GestureButton) findViewById(R.id.ghi_gb);
        jklGb = (GestureButton) findViewById(R.id.jkl_gb);
        mnoGb = (GestureButton) findViewById(R.id.mno_gb);
        pqrsGb = (GestureButton) findViewById(R.id.pqrs_gb);
        tuvGb = (GestureButton) findViewById(R.id.tuv_gb);
        wxyzGb = (GestureButton) findViewById(R.id.wxyz_gb);
        if (SharedPreferencesUtils.getBooleanSharedPreferencesData(context, ShareKeys.IS_OTHER_LETTER_ORDER, false)) {
            setupKeys();
        } else {
            setupKeys1();
        }
        deleteBtn = findViewById(R.id.delete_btn);
        spaceBtn = findViewById(R.id.space_btn);
        okBtn = findViewById(R.id.ok_btn);
        helpBtn = findViewById(R.id.help_btn);
        optionsBtn = findViewById(R.id.options_iv);

        optionsBtn.setOnClickListener(this);
        helpBtn.setOnClickListener(this);
        abcGb.setOnResultListener(this);
        defGb.setOnResultListener(this);
        ghiGb.setOnResultListener(this);
        jklGb.setOnResultListener(this);
        mnoGb.setOnResultListener(this);
        pqrsGb.setOnResultListener(this);
        tuvGb.setOnResultListener(this);
        wxyzGb.setOnResultListener(this);
        deleteBtn.setOnClickListener(this);
        spaceBtn.setOnClickListener(this);
        okBtn.setOnClickListener(this);
        deleteBtn.setOnLongClickListener(new View.OnLongClickListener() {
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
        this.setVisibility(VISIBLE);
    }

    private void setupKeys() {
        abcGb.setKeys("bac");
        defGb.setKeys("edf");
        ghiGb.setKeys("hgi");
        jklGb.setKeys("kjl");
        mnoGb.setKeys("nmo");
        pqrsGb.setKeys("qprs");
        tuvGb.setKeys("utv");
        wxyzGb.setKeys("xwyz");
    }

    private void setupKeys1() {
        abcGb.setKeys("abc");
        defGb.setKeys("def");
        ghiGb.setKeys("ghi");
        jklGb.setKeys("jkl");
        mnoGb.setKeys("mno");
        pqrsGb.setKeys("pqrs");
        tuvGb.setKeys("tuv");
        wxyzGb.setKeys("wxyz");
    }

    protected void onOkBtnClick() {
        if (null != mOnKeyboardChangeListener) {
            mOnKeyboardChangeListener.onFinish(mEditText.getText().toString());
        }
        mEditText.setText("");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete_btn:
                delete(false);
                break;
            case R.id.ok_btn:
                onOkBtnClick();
                break;
            case R.id.space_btn:
                handleInsert(" ");
                break;
            case R.id.help_btn:
                if (null != mOnKeyboardListener) {
                    mOnKeyboardListener.onQuestionClick();
                }
                break;
            case R.id.options_iv:
                if (null != mOnKeyboardListener) {
                    mOnKeyboardListener.onOptionsClick();
                }
                break;
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

    @Override
    public void onResult(String result) {
        handleInsert(result);
    }

    @Override
    public void onChange(String result) {
        if (null != mOnKeyboardChangeListener) {
            mOnKeyboardChangeListener.onChange(result);
        }
    }

    public void setOnKeyboardChangeListener(OnKeyboardChangeListener onKeyboardChangeListener) {
        mOnKeyboardChangeListener = onKeyboardChangeListener;
    }

    public void setOnKeyboardListener(OnKeyboardListener onKeyboardListener) {
        mOnKeyboardListener = onKeyboardListener;
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
}
