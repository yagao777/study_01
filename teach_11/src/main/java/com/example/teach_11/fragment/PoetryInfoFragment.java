package com.example.teach_11.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 由于显示的数据和布局是一样的，所以我们可以只用一个Fragment。
// 对于不同的数据，我们通过一个数据Model来描述
public class PoetryInfoFragment extends Fragment {


    // 如何传递一个Model给Fragment呢？
    // 通常我们会通过
    // 一般的写法如下
    public static PoetryInfoFragment newInstance(){
        Bundle bundle = new Bundle();
        // bundle 和Intent很类似，我们可以将各种各样的数据放到其中
//        bundle.putString("key","value");

        PoetryInfoFragment fragment = new PoetryInfoFragment();
        // 将数据放到Fragment中
        fragment.setArguments(bundle);
        return fragment;
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
                String value = bundle.getString("key");
            }
        }


    }
}
