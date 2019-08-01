package com.example.study_11.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.study_11.R;
import com.example.study_11.adapter.MyAdapter;
import com.example.study_11.adapter.PoetryInfoPageAdapter;
import com.example.study_11.adapter.PoetryPageAdapter;
import com.example.study_11.model.PoetryDynamicModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class PoetryDynamicFragment extends Fragment {

//    private Button btnUpdate;
//    private PoetryInfoAFragment poetryInfoAFragment;
//    private PoetryInfoBFragment poetryInfoBFragment;
    private PoetryInfoFragment poetryInfoFragment;
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_poetry_dynamic, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        btnUpdate = view.findViewById(R.id.btn_update);

        ViewPager viewPager = view.findViewById(R.id.vp_poetry);
        viewPager.setAdapter(new PoetryInfoPageAdapter(getFragmentManager(), mockData()));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        poetryInfoAFragment = new PoetryInfoAFragment();
//        poetryInfoBFragment = new PoetryInfoBFragment();
        poetryInfoFragment = new PoetryInfoFragment();



//        getFragmentManager().beginTransaction().add(R.id.vp_poetry,poetryInfoAFragment).commit();
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getFragmentManager().beginTransaction().replace(R.id.container,poetryInfoBFragment).commit();
//            }
//        });

    }

    private List<PoetryDynamicModel> mockData() {
        List<PoetryDynamicModel> models = new ArrayList<>();
        models.add( new PoetryDynamicModel("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=56815293,4106492494&fm=58&bpow=511&bpoh=638",
                "李清照",
                "如梦令\n" +
                        "常记溪亭日暮，沉醉不知归路。兴尽晚回舟，误入藕花深处。争渡，争渡，惊起一滩鸥鹭。 \n",
                System.currentTimeMillis()));
        models.add(new PoetryDynamicModel("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3550320184,1957274929&fm=58&bpow=400&bpoh=508",
                "辛弃疾",
                "破阵子·为陈同甫赋壮词以寄\n" +
                        "醉里挑灯看剑，梦回吹角连营。八百里分麾下炙，五十弦翻塞外声。沙场秋点兵。\n" +
                        "马作的卢飞快，弓如霹雳弦惊。了却君王天下事，赢得生前身后名。可怜白发生！\n",
                System.currentTimeMillis()));
        return models;
    }

}
