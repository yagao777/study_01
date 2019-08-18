package com.example.study_project_01;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.study_project_01.Adapter.AnswerAdapter;
import com.example.study_project_01.Adapter.CircleAdapter;
import com.example.study_project_01.Adapter.ContentAdapter;
import com.example.study_project_01.Adapter.UserinfoPageAdapter;
import com.example.study_project_01.Model.AnswerModel;
import com.example.study_project_01.Model.CircleModel;
import com.example.study_project_01.Model.ContentModel;
import com.example.study_project_01.event.UpdateUserEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class UserinfoActivity extends AppCompatActivity {
    private TextView tv_info_content;
    private TextView tv_info_answer;
    private TextView tv_info_circle;
    private TextView tv_name;
    private ImageView iv_back;

    private SQLiteDatabase sqLiteDatabase1;
    private MessageSQLiteOpenHelper dbHelper1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 注册EventBus
        EventBus.getDefault().register(this);

        setContentView(R.layout.activity_userinfo);

        iv_back = findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFinishing()) {
                    finish();
                }
            }
        });


        final ViewPager viewPager = findViewById(R.id.vp_userinfo);

        tv_info_content = findViewById(R.id.tv_info_content);
        tv_info_answer = findViewById(R.id.tv_info_answer);
        tv_info_circle = findViewById(R.id.tv_info_circle);
        tv_name = findViewById(R.id.tv_name);

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserinfoActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        viewPager.setAdapter(new UserinfoPageAdapter(this, mockData1(), mockData2(), mockData3()));

        findViewById(R.id.tv_info_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
            }
        });

        findViewById(R.id.tv_info_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

        findViewById(R.id.tv_info_circle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        tv_info_content.setHovered(true);

        //查询tv_name
        dbHelper1 = new MessageSQLiteOpenHelper(getApplicationContext(), "test_carson");
        sqLiteDatabase1 = dbHelper1.getWritableDatabase();

        System.out.println("查询数据");

        String id = "1";

        Cursor cursor = sqLiteDatabase1.query("user", new String[]{"id",
                "name"}, "id = ?", new String[]{id}, null, null, null);

        String userId = null;
        String name = null;

        if (cursor.moveToNext()) {
            userId = cursor.getString(cursor.getColumnIndex("id"));
            name = cursor.getString(cursor.getColumnIndex("name"));

            Log.d("yagao", "userId:" + userId + "name:" + name);
            cursor.close();
        }

        tv_name.setText(userId);
        tv_name.setText(name);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0){
//                    tv_info_content.setTextColor(getResources().getColor(R.color.colorAccent));
//                    tv_info_answer.setTextColor(getResources().getColor(R.color.bind_black_color));
//                    tv_info_circle.setTextColor(getResources().getColor(R.color.bind_black_color));

                    tv_info_content.setHovered(true);
                    tv_info_answer.setHovered(false);
                    tv_info_circle.setHovered(false);

                } else if (position == 1){
//                    tv_info_answer.setTextColor(getResources().getColor(R.color.colorAccent));
//                    tv_info_content.setTextColor(getResources().getColor(R.color.bind_black_color));
//                    tv_info_circle.setTextColor(getResources().getColor(R.color.bind_black_color));

                    tv_info_content.setHovered(false);
                    tv_info_answer.setHovered(true);
                    tv_info_circle.setHovered(false);
                } else if (position == 2){
//                    tv_info_circle.setTextColor(getResources().getColor(R.color.colorAccent));
//                    tv_info_content.setTextColor(getResources().getColor(R.color.bind_black_color));
//                    tv_info_answer.setTextColor(getResources().getColor(R.color.bind_black_color));

                    tv_info_content.setHovered(false);
                    tv_info_answer.setHovered(false);
                    tv_info_circle.setHovered(true);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private List<ContentModel> mockData1() {
        List<ContentModel> contentModels = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            contentModels.add(new ContentModel("https://imgsrc.baidu.com/baike/pic/item/42a98226cffc1e1767f4b11e4690f603738de952.jpg",
                    "alkjdsfsjfsjagjjoajfeiw", System.currentTimeMillis()));
        }
        return contentModels;
    }

    private List<AnswerModel> mockData2() {
        List<AnswerModel> answerModels = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            answerModels.add(new AnswerModel("问题", System.currentTimeMillis()));
        }
        return answerModels;
    }

    private List<CircleModel> mockData3() {
        List<CircleModel> circleModels = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            circleModels.add(new CircleModel("slfdiconmwcfweco", "https://imgsrc.baidu.com/baike/pic/item/42a98226cffc1e1767f4b11e4690f603738de952.jpg"));
        }
        return circleModels;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUpdateUser(UpdateUserEvent event) {
        tv_name.setText(event.userName);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
