package com.insightsurfface.stylelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.insightsurfface.stylelibrary.keyboard.English9KeyBoardView;
import com.insightsurfface.stylelibrary.listener.OnKeyboardChangeListener;

public class MainActivity extends AppCompatActivity {
    private EditText testEt;
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

    @Override
    public void onBackPressed() {
        if (keyboardV.isShown()) {
            keyboardV.hide();
        } else {
            super.onBackPressed();
        }
    }
}
