package com.example.study_summary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.example.study_summary.adapter.MyAdapter;
import com.example.study_summary.adapter.PoetryImageAdapter;
import com.example.study_summary.model.MyModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        MyAdapter adapter = new MyAdapter(mockData());
        recycler.setAdapter(adapter);

        viewPager = findViewById(R.id.vp_img);
        viewPager.setAdapter(new PoetryImageAdapter(this));

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
            models.add(new MyModel("如梦令·常记溪亭日暮\n" , "常记溪亭日暮，沉醉不知归路。兴尽晚回舟，误入藕花深处。争渡，争渡，惊起一滩鸥鹭。\n", "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=56815293,4106492494&fm=58&bpow=511&bpoh=638",
                    System.currentTimeMillis()));
            models.add(new MyModel("卜算子·咏梅\n" , "驿外断桥边，寂寞开无主。已是黄昏独自愁，更著风和雨。(著 同：着) \n" +
                    "无意苦争春，一任群芳妒。零落成泥碾作尘，只有香如故。\n", "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3550320184,1957274929&fm=58&bpow=400&bpoh=508\n",
                    System.currentTimeMillis()));
            models.add(new MyModel("水调歌头·明月几时有\n" , "明月几时有？把酒问青天。不知天上宫阙，今夕是何年。我欲乘风归去，又恐琼楼玉宇，高处不胜寒。起舞弄清影，何似在人间？(何似 一作：何时；又恐 一作：惟 / 唯恐)\n" +
                    "转朱阁，低绮户，照无眠。不应有恨，何事长向别时圆？人有悲欢离合，月有阴晴圆缺，此事古难全。但愿人长久，千里共婵娟。(长向 一作：偏向)\n", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDibGIakrNRkov5X7AODtDsuxyn2m2gcJuvGiTl-quSZSOd581\n",
                    System.currentTimeMillis()));
        }

        return models;
    }

}
