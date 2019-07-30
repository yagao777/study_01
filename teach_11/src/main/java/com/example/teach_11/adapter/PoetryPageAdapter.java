package com.example.teach_11.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.teach_11.fragment.PoetryDynamicFragment;
import com.example.teach_11.fragment.PoetryListFragment;

// 当Fragment个数较少，且数量是确定时，我们继承自FragmentPagerAdapter
public class PoetryPageAdapter extends FragmentPagerAdapter {
    public PoetryPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            // 第一个页面
            return new PoetryListFragment();
        else
            // 第二个页面
            return new PoetryDynamicFragment();
    }

    // 这里返回总共有多少个Fragment
    @Override
    public int getCount() {
        return 2;
    }
}
