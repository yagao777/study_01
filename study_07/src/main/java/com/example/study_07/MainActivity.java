package com.example.study_07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        MyAdapter adapter = new MyAdapter(mockData());
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MyModel model) {
                // Item点击时，就会调用这个方法，在这里面我们做Activity的跳转

                Intent intent = new Intent(MainActivity.this, DetailModifyActivity.class);
                intent.putExtra("entity", model);
                startActivity(intent);
        }
        });
    }


    private List<MyModel> mockData() {
        List<MyModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            models.add(new MyModel("将进酒" , "君不见，黄河之水天上来，奔流到海不复回。\n" +
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