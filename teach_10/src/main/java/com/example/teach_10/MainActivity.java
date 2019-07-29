package com.example.teach_10;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.teach_10.adapter.PoetryPageAdapter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ViewPager让一个Activity能够展示多个页面
        // 通过左右切，滑动，可以实现多个页面的切换
        ViewPager viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(new PoetryPageAdapter(getSupportFragmentManager()));
    }

}