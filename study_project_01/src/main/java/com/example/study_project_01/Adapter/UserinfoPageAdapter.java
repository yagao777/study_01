package com.example.study_project_01.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.study_project_01.Model.AnswerModel;
import com.example.study_project_01.Model.CircleModel;
import com.example.study_project_01.Model.ContentModel;
import com.example.study_project_01.R;

import java.util.List;

public class UserinfoPageAdapter extends PagerAdapter {

    private final LayoutInflater inflater;
    private List<ContentModel> contentModelList;
    private List<AnswerModel> answerModelList;
    private List<CircleModel> circleModelList;

    public UserinfoPageAdapter(Context context, List<ContentModel> contentModelList, List<AnswerModel> answerModelList, List<CircleModel> circleModelList) {
        inflater = LayoutInflater.from(context);
        this.answerModelList = answerModelList;
        this.contentModelList = contentModelList;
        this.circleModelList = circleModelList;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        RecyclerView view = (RecyclerView) inflater.inflate(R.layout.content_list, container, false);

        view.setLayoutManager(new LinearLayoutManager(container.getContext(), RecyclerView.VERTICAL, false));

        if (position == 0) {
            view.setAdapter(new ContentAdapter(contentModelList));
        } else if (position == 1) {
            view.setAdapter(new AnswerAdapter(answerModelList));

        } else {
            view.setAdapter(new CircleAdapter(circleModelList));

        }

        container.addView(view);

        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
