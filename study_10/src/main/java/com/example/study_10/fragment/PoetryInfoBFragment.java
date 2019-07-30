package com.example.study_10.fragment;

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
import com.example.study_10.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PoetryInfoBFragment extends Fragment {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    private ImageView ivAuthor2;
    private TextView tvAuthor2;
    private TextView tvContent2;
    private TextView tvTime4;

    private String author2_header_url = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3550320184,1957274929&fm=58&bpow=400&bpoh=508";
    private String author2_name = "辛弃疾";
    private String author2_content = "破阵子·为陈同甫赋壮词以寄\n" +
            "醉里挑灯看剑，梦回吹角连营。八百里分麾下炙，五十弦翻塞外声。沙场秋点兵。\n" +
            "马作的卢飞快，弓如霹雳弦惊。了却君王天下事，赢得生前身后名。可怜白发生！\n";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_poetry_info_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivAuthor2 = view.findViewById(R.id.iv_author2);
        tvAuthor2 = view.findViewById(R.id.tv_author2);
        tvContent2 = view.findViewById(R.id.tv_content2);
        tvTime4 = view.findViewById(R.id.tv_time4);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Glide.with(this).load(author2_header_url).into(ivAuthor2);
        tvAuthor2.setText(author2_name);
        tvContent2.setText(author2_content);
        tvTime4.setText(format.format(new Date(System.currentTimeMillis())));
    }
}
