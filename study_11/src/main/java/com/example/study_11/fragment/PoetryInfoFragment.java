package com.example.study_11.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.study_11.R;
import com.example.study_11.adapter.PoetryPageAdapter;
import com.example.study_11.model.PoetryDynamicModel;

import java.text.SimpleDateFormat;
import java.util.Date;


// 由于显示的数据和布局是一样的，所以我们可以只用一个Fragment。
// 对于不同的数据，我们通过一个数据Model来描述
public class PoetryInfoFragment extends Fragment {

    public static final String POETRY_MODEL = "poetry_model";
    private ImageView ivAuthor;
    private TextView tvAuthor;
    private TextView tvContent;
    private TextView tvTime;
    private PoetryDynamicModel model;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    // 如何传递一个Model给Fragment呢？
    // 通常我们会通过
    // 一般的写法如下
    // 实例化方法
    public static PoetryInfoFragment newInstance(PoetryDynamicModel model){
        Bundle bundle = new Bundle();
        // bundle 和Intent很类似，我们可以将各种各样的数据放到其中
        // bundle.putString("key","value");
        bundle.putParcelable(POETRY_MODEL,model);

        PoetryInfoFragment fragment = new PoetryInfoFragment();
        // 将数据放到Fragment中
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_portry_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivAuthor = view.findViewById(R.id.iv_author);
        tvAuthor = view.findViewById(R.id.tv_author);
        tvContent = view.findViewById(R.id.tv_content);
        tvTime = view.findViewById(R.id.tv_time);
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
                model = bundle.getParcelable(POETRY_MODEL);
            }
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Glide.with(this).load(model.getAuthor_header_url()).into(ivAuthor);
        tvAuthor.setText(model.getAuthor_name());
        tvContent.setText(model.getAuthor_content());
        tvTime.setText(format.format(new Date(System.currentTimeMillis())));

    }

}
