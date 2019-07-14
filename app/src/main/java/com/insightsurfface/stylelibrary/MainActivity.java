package com.insightsurfface.stylelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.insightsurfface.stylelibrary.keyboard.English9KeyBoardView;

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
        keyboardV = (English9KeyBoardView) findViewById(R.id.keyboard_v);
        keyboardV.attachTo(testEt);
    }
}
