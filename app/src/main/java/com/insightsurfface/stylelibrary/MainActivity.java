package com.insightsurfface.stylelibrary;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.insightsurfface.stylelibrary.dialog.EditDialog;
import com.insightsurfface.stylelibrary.keyboard.English9KeyBoardView;
import com.insightsurfface.stylelibrary.keyboard.LandscapeKeyBoardDialog;
import com.insightsurfface.stylelibrary.listener.OnEditResultListener;
import com.insightsurfface.stylelibrary.listener.OnKeyboardChangeListener;

public class MainActivity extends AppCompatActivity {
    private EditText testEt;
    private Button testBtn, testBtn1;
    private English9KeyBoardView keyboardV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2019-07-14 13:55:17 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        testEt = (EditText) findViewById(R.id.test_et);
        testBtn = findViewById(R.id.test_btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLandscapeEditDialog();
            }
        });
        testBtn1 = findViewById(R.id.test_btn1);
        testBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShelterOptionDialog();
            }
        });
        testEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardV.show();
            }
        });
        keyboardV = (English9KeyBoardView) findViewById(R.id.keyboard_v);
        keyboardV.attachTo(testEt);
        keyboardV.setOnKeyboardChangeListener(new OnKeyboardChangeListener() {
            @Override
            public void onChange(String res) {

            }

            @Override
            public void onFinish(String res) {
                Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
            }
        });
        keyboardV.show();
    }

    private void showShelterOptionDialog() {
        EditDialog dialog = new EditDialog(this);
        dialog.setOnEditResultListener(new OnEditResultListener() {
            @Override
            public void onResult(String text) {
            }

            @Override
            public void onCancelClick() {

            }
        });
        dialog.show();
        dialog.setOnlyNumInput(true);
        dialog.setTitle("遮挡高度设置");
        dialog.setHint("默认值为30dp 仅供参考");
        dialog.setMessage("请输入要设置的遮挡高度(单位：dp)，如需隐藏遮挡请输入0。");
    }

    private void showLandscapeEditDialog() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        LandscapeKeyBoardDialog dialog = new LandscapeKeyBoardDialog(this);
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (keyboardV.isShown()) {
            keyboardV.hide();
        } else {
            super.onBackPressed();
        }
    }
}
