package com.example.study_summary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.study_summary.adapter.PoetryAppreciationPageAdapter;
import com.example.study_summary.model.MyModel;
import com.example.study_summary.model.PoetryDynamicModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MyModel model = getIntent().getParcelableExtra("entity");

        ViewPager viewPager = findViewById(R.id.vp_poetry);
        viewPager.setAdapter(new PoetryAppreciationPageAdapter(getSupportFragmentManager(), mockData(),model));

    }

    private List<PoetryDynamicModel> mockData() {
        List<PoetryDynamicModel> models = new ArrayList<>();
        models.add( new PoetryDynamicModel("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=56815293,4106492494&fm=58&bpow=511&bpoh=638",
                "宋代：李清照\n",
                "如梦令·常记溪亭日暮\n" +"此词是记游赏之作，写了酒醉、花美，清新别致。“常记”两句起笔平淡，自然和谐，把读者自然而然地引到了她所创造的词境 。“常记”明确表示追述，地点在“溪亭 ”，时间是“日暮 ”，作者饮宴以后 ，已经醉得连回去的路径都辨识不出了。“沉醉”二字却露了作者心底的欢愉 ，“不知归路”也曲折传出作者流连忘返的情致，看起来，这是一次给作者留下了深刻印象的十分愉快的游赏。\n",
                System.currentTimeMillis()));
        models.add(new PoetryDynamicModel("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3550320184,1957274929&fm=58&bpow=400&bpoh=508",
                "宋代：陆游\n",
                "卜算子·咏梅\n" +
                        "此词以梅花自况，咏梅的凄苦以泄胸中抑郁，感叹人生的失意坎坷；赞梅的精神又表达了青春无悔的信念以及对自己爱国情操及高洁人格的自许。\n" +
                        "　　词的上半阕着力渲染梅的落寞凄清、饱受风雨之苦的情形。陆游曾经称赞梅花“雪虐风饕愈凛然，花中气节最高坚”（《落梅》）。梅花如此清幽绝俗，出于众花之上，可是“如今”竟开在郊野的驿站外面，紧临着破败不堪的“断桥”，自然是人迹罕至、寂寥荒寒、倍受冷落、令人怜惜了。无人照看与护理，其生死荣枯全凭自己。“断桥”已失去沟通两岸的功能，唯有断烂木石，更是人迹罕至之处。由于这些原因，它只能“寂寞开无主”了，“无主”既指无人照管，又指梅花无人赏识，不得与人亲近交流而只能孤芳自赏，独自走完自己的生命历程而已。\n",
                System.currentTimeMillis()));
        models.add(new PoetryDynamicModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDibGIakrNRkov5X7AODtDsuxyn2m2gcJuvGiTl-quSZSOd581\n",
                "宋代：苏轼\n",
                "水调歌头·明月几时有\n" +
                        "在大自然的景物中，月亮是很有浪漫色彩的，很容易启发人们的艺术联想。一钩新月，可联想到初生的萌芽事物；一轮满月，可联想到美好的团圆生活；月亮的皎洁，让人联想到光明磊落的人格。在月亮这一意象上集中了人类无限美好的憧憬和理想。\n" +
                        "苏轼是一位性格豪放、气质浪漫的文学家，当他抬头遥望中秋明月时，其思想情感犹如长上了翅膀，天上人间自由翱翔。反映到词里，遂形成了一种豪放洒脱的风格。\n",
                System.currentTimeMillis()));
        return models;
    }

}