package com.example.study_05;

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

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("entity", model);
                startActivity(intent);
        }
        });
    }


    private List<MyModel> mockData() {
        List<MyModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            models.add(new MyModel("title:" + i, "this is subtitle " + i,
                    "https://img.4gamers.com.tw/ckfinder/images/TangBao/1812/19-pikachu-01.jpg"));
        }

        return models;
    }
}