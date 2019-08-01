package com.example.study_11.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study_11.DetailActivity;
import com.example.study_11.R;
import com.example.study_11.adapter.MyAdapter;
import com.example.study_11.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class PoetryListFragment extends Fragment {

    RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 我们在把Fragment的布局文件填充进来
        return inflater.inflate(R.layout.fragment_poetry_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 到这一步， Fragment对应的View已经被创建出来，我们可以在这里找到所有的控件
        // ... findViewById
        recycler = view.findViewById(R.id.recycler);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这个方法不要和Activity的onCreate方法搞混了，在这个方法被执行时，Activity是没有创建的
        // 如果我们在这里调用findViewById获取控件，就会报错，崩溃

        // 一般在这里做一些和View没有关系的初始化工作

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 这个方法是Fragment中比较重要的，我们在Fragment中经常会用到Activity的实例(通过getActivity()方法)
        // 只有在这个方法执行之后，我们才能确定Activity已经被创建了，这时才能使用，否则拿到的是null

        // 在这里可是开始做和View有关的初始化工作...

        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));

        MyAdapter adapter = new MyAdapter(mockData());
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MyModel model) {
                // Item点击时，就会调用这个方法，在这里面我们做Activity的跳转

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("entity", model);
                startActivity(intent);
            }
        });

    }

    private List<MyModel> mockData() {
        List<MyModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            models.add(new MyModel("将进酒", "君不见，黄河之水天上来，奔流到海不复回。\n" +
                    "君不见，高堂明镜悲白发，朝如青丝暮成雪。\n" +
                    "人生得意须尽欢，莫使金樽空对月。\n" +
                    "天生我材必有用，千金散尽还复来。\n" +
                    "烹羊宰牛且为乐，会须一饮三百杯。\n" +
                    "岑夫子，丹丘生，将进酒，杯莫停。\n" +
                    "与君歌一曲，请君为我倾耳听。\n" +
                    "钟鼓馔玉不足贵，但愿长醉不复醒。\n" +
                    "古来圣贤皆寂寞，惟有饮者留其名。\n" +
                    "陈王昔时宴平乐，斗酒十千恣欢谑。\n" +
                    "主人何为言少钱，径须沽取对君酌。\n" +
                    "五花马，千金裘，呼儿将出换美酒，与尔同销万古愁。\n", "https://imgsrc.baidu.com/baike/pic/item/42a98226cffc1e1767f4b11e4690f603738de952.jpg",
                    System.currentTimeMillis()));
        }

        return models;
    }
}
