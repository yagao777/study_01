package com.example.study_11;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.study_11.adapter.PoetryPageAdapter;
import com.example.study_11.fragment.PoetryInfoAFragment;
import com.example.study_11.fragment.PoetryInfoBFragment;

import java.util.ArrayList;
import java.util.List;


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