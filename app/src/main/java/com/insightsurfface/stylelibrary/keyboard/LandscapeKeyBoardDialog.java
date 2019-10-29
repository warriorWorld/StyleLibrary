package com.insightsurfface.stylelibrary.keyboard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.insightsurfface.stylelibrary.R;


public class LandscapeKeyBoardDialog extends Dialog {
    protected Context context;
    private EditText dialogEt;
    private English26KeyBoardView mEnglish26KeyBoardView;
    private English26KeyBoardView.KeyBorad26Listener mKeyBorad26Listener;

    public LandscapeKeyBoardDialog(Context context) {
        super(context);
        // 閺夆晜鐟ч～鎺楀棘閻熸壆纭�闁告瑯鍨禍鎺旀媼閳哄伅顓㈠触閹存繂寮块悘鐑囨嫹 濞达絽妫欏Σ鎼佸极閸喓浜☉鎾崇Т閵囧﹥绺介敓锟�
        // super(context, android.R.style.Theme);
        // setOwnerActivity((Activity) context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        init();

        windowSet();
    }

    protected int getLayoutId() {
        return R.layout.dialog_keyboard_landscape;
    }

    protected void windowSet() {
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        WindowManager wm = ((Activity) context).getWindowManager();
        Display d = wm.getDefaultDisplay(); // 闁兼儳鍢茶ぐ鍥╀沪韫囨挾顔庨悗鐟邦潟閿熸垝绶氶悵顕�鎮介敓锟�
        // lp.height = (int) (d.getHeight() * 0.4); // 濡ゅ倹锚鐎瑰磭鎷嬮崜褏鏋�
        lp.width = (int) (d.getWidth() * 1); // 閻庣妫勭�瑰磭鎷嬮崜褏鏋�
        // window.setGravity(Gravity.LEFT | Gravity.TOP);
        window.setGravity(Gravity.BOTTOM);
        // dialog濮掓稒顭堥鑽や焊鏉堛劍绠抪adding 閻庝絻澹堥崵褎淇婇崒娑氫函濞戞挸绉风换鏍ㄧ▕閸綆鍟庣紓鍐惧枤濞堟垹鎷犻敓锟�
        // dialog婵ɑ鐡曠换娆愮▔瀹ュ牆鍘撮柛蹇嬪妼閻拷
        window.getDecorView().setPadding(0, 0, 0, 0);
        // lp.x = 100; // 闁哄倿顣︾紞鍛磾閻㈡棃宕搁幇顓犲灱
        // lp.y = 100; // 闁哄倿顣︾紞鍛磾閻㈡洟宕搁幇顓犲灱
        // lp.height = 30;
        // lp.width = 20;
        window.setAttributes(lp);
        window.setDimAmount(0.2f);//去掉蒙层
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    protected void init() {
        dialogEt = (EditText) findViewById(R.id.dialog_et);
        mEnglish26KeyBoardView = findViewById(R.id.keyboard_v);
        mEnglish26KeyBoardView.attachTo(dialogEt);
        mEnglish26KeyBoardView.setKeyBorad26Listener(new English26KeyBoardView.KeyBorad26Listener() {
            @Override
            public void inputFinish(String s) {
                if (null != mKeyBorad26Listener) {
                    mKeyBorad26Listener.inputFinish(s);
                }
            }

            @Override
            public void closeKeyboard() {
                dismiss();
                if (null != mKeyBorad26Listener) {
                    mKeyBorad26Listener.closeKeyboard();
                }
            }
        });
    }

    public void setKeyBorad26Listener(English26KeyBoardView.KeyBorad26Listener keyBorad26Listener) {
        mKeyBorad26Listener = keyBorad26Listener;
    }
}
