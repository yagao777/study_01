package com.example.teach_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * 要求, Item的高度为100dp, TextView1的字体大小为16sp,颜色为黑色, TextView2的字体颜色为灰色,12sp;
 * 左边为一个ImageView 宽高为120*60, 显示res下的ic_launcher图标;
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
