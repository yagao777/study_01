package com.example.teach_04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler);

        // 1，为RecyclerView设置一个布局管理器
        // 布局管理器是用来设置RecyclerView中Item的排列方式，通过设置不同的LayoutManager，我们让RecyclerView的
        // Item呈现不同的排列方式，比如这里，我们使用线性布局排列方式，LinearLayoutManager，这个线性可以是垂直的
        // RecyclerView.VERTICAL，也可以是水平的RecyclerView.HORIZONTAL, 这里需要列表垂直展示，使用VERTICAL

        // 参数3一般设置为false，reverse意思为反方向的，它的作用是设置RecyclerView是否反方向布局，从下往上布局Item
        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        // 2，为RecyclerView设置一个适配器
        /*
        可以看到，我们在布局文件activity_main中，是没有为RecyclerView设置列表Item的，不像teach_03中的ScrollView，
        列表Item直接写在布局中，RecyclerView需要通过适配器来进行动态创建。(不用问我RecyclerView可不可以把列表Item
        写在布局中，答案，是不行的！)

        所谓适配器，其作用当然就是适配啦！我们需要列表Item无缝的衔接到RecyclerView中，就通过它来实现；
        大概步骤就是，当适配器被设置到RecyclerView中，它会先判断适配器中能够创建的Item数量，如果大于0，就会调用适配
        器对应的方法，创建列表Item对应的View，然后将View添加RecyclerView中。

        RecyclerView会根据当前屏幕能够显示下多少个Item，来调用对应次数适配器中创建View的方法，创建出对应数量的列表Item。

        注意，RecyclerView中，每一个Item都是有一个对应的下标的. 所谓下标，可以理解为位置，从RecyclerView顶部往下
        算，第一个Item对应的下标为0，最后一个Item的下标为总的Item数减去1。（注意，我这里所说的顶部第一个Item是在我们
        还没有滚动列表时的第一个，当我们滚动过列表，顶部第一个Item下标可能是大于0的任意值，取决于你滚动了多来。）
         */
        recycler.setAdapter(new MyAdapter());
    }
}
