package com.example.study_11.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.study_11.fragment.PoetryInfoFragment;
import com.example.study_11.model.PoetryDynamicModel;

import java.util.List;

public class PoetryInfoPageAdapter extends FragmentPagerAdapter {

    private List<PoetryDynamicModel> models;

    public PoetryInfoPageAdapter(FragmentManager fm,List<PoetryDynamicModel> models) {
        super(fm);
        this.models = models;
    }

    @Override
    public Fragment getItem(int position) {
        return PoetryInfoFragment.newInstance(models.get(position));
    }

    @Override
    public int getCount() {
        return models.size();
    }
}
