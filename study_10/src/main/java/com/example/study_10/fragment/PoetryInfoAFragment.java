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

public class PoetryInfoAFragment extends Fragment {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd HH:mm");

    private ImageView ivAuthor1;
    private TextView tvAuthor1;
    private TextView tvContent;
    private TextView tvTime3;

    private String author_header_url = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=56815293,4106492494&fm=58&bpow=511&bpoh=638";
    private String author_name = "李清照";
    private String author_content = "如梦令\n" +
            "常记溪亭日暮，沉醉不知归路。兴尽晚回舟，误入藕花深处。争渡，争渡，惊起一滩鸥鹭。 \n";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_poetry_info_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivAuthor1 = view.findViewById(R.id.iv_author1);
        tvAuthor1 = view.findViewById(R.id.tv_author1);
        tvContent = view.findViewById(R.id.tv_content);
        tvTime3 = view.findViewById(R.id.tv_time3);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Glide.with(this).load(author_header_url).into(ivAuthor1);
        tvAuthor1.setText(author_name);
        tvContent.setText(author_content);
        tvTime3.setText(format.format(new Date(System.currentTimeMillis())));
    }

}


