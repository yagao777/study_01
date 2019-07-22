package com.example.teach_05;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

            }
        });
    }

    // 构建一个模拟数据
    private List<MyModel> mockData() {
        List<MyModel> models = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            models.add(new MyModel("title:" + i, "this is subtitle " + i,
                    "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=171564417,1145903032&fm=26&gp=0.jpg"));
        }

        return models;
    }
}
