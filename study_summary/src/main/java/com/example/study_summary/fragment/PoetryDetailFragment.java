package com.example.study_summary.fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.study_summary.R;
import com.example.study_summary.model.MyModel;

import java.text.SimpleDateFormat;


public class PoetryDetailFragment extends Fragment {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm");
    public static final String DETAIL_MODEL = "detail_model";
    private ImageView ivDetail1;
    public TextView tvTitle;
    private TextView tvContent;
    private TextView tvTime2;

    private MyModel model;

    public static PoetryDetailFragment newInstance(MyModel model){
        Bundle bundle = new Bundle();
        // bundle 和Intent很类似，我们可以将各种各样的数据放到其中
        // bundle.putString("key","value");
        bundle.putParcelable(DETAIL_MODEL,model);

        PoetryDetailFragment fragment = new PoetryDetailFragment();
        // 将数据放到Fragment中
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_poetry_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivDetail1 = view.findViewById(R.id.iv_detail1);
        tvTitle = view.findViewById(R.id.tv_title);
        tvContent = view.findViewById(R.id.tv_content);
        tvTime2 = view.findViewById(R.id.tv_time2);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // savedInstanceState这个和Activity的onCreate方法的savedInstanceState是同理的
        if (savedInstanceState != null) {
            // 说明之前Activity在后台被杀死过，并且在杀死之前，我们保存了数据

        } else {
            // 正常情况
            // 和Activity的onCreate方法类似，我们可以在这里直接拿到放置到Fragment中的数据
            // 唯一的区别是，Activity是通过getIntent拿，而Fragment通过getArguments拿
            // 这个是我们放到Fragment的那个Bundle
            Bundle bundle = getArguments();
            if (bundle != null) {
                model = bundle.getParcelable(DETAIL_MODEL);
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvTitle.setText(model.getTitle());
        tvContent.setText(model.getSubTitle());
        Glide.with(this).load(model.getUrl()).into(ivDetail1);
        tvTime2.setText(format.format(model.getTime()));

    }


}


