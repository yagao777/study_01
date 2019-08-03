package com.example.study_summary.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.study_summary.fragment.PoetryAppreciationFragment;
import com.example.study_summary.fragment.PoetryDetailFragment;
import com.example.study_summary.model.MyModel;
import com.example.study_summary.model.PoetryDynamicModel;

import java.util.List;

public class PoetryAppreciationPageAdapter extends FragmentPagerAdapter {

    private List<PoetryDynamicModel> models;
    private MyModel myModel;

    public PoetryAppreciationPageAdapter(FragmentManager fm, List<PoetryDynamicModel> models, MyModel myModel) {
        super(fm);
        this.models = models;
        this.myModel = myModel;
    }

    // position 0,1,2,3
    @Override
    public Fragment getItem(int position) {
        //
        if (position == 0) {
            return PoetryDetailFragment.newInstance(myModel);
        }

        // 1,2,3
        //
        int index = position - 1;

        PoetryDynamicModel dynamicModel = models.get(index);

        return PoetryAppreciationFragment.newInstance(dynamicModel);
    }

    @Override
    public int getCount() {
        return models.size()+1;
    }
}
