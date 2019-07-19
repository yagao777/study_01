package com.example.teach_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1， 要求设置TextView字体颜色为白色；
 * 2， 设置TextView背景色为黑色；
 * 3，让TextView中的字体居中显示；(tip: 采用和LinearLayout相同的方式)
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_test;

    // 声明一个集合，用来保存所有TextView
    private List<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);
        Button btn_set_content = findViewById(R.id.btn_set_content);
        btn_set_content.setOnClickListener(this);

        TextView tv_1 = findViewById(R.id.tv_1);
        TextView tv_2 = findViewById(R.id.tv_2);
        TextView tv_3 = findViewById(R.id.tv_3);
        TextView tv_4 = findViewById(R.id.tv_4);
        TextView tv_5 = findViewById(R.id.tv_5);

        textViews.add(tv_1);
        textViews.add(tv_2);
        textViews.add(tv_3);
        textViews.add(tv_4);
        textViews.add(tv_5);
    }


    @Override
    public void onClick(View view) {
        // 获取用户输入到到et_test的内容
        String content = et_test.getText().toString();
        // 清空EditText的内容
        et_test.getText().clear();
        // 遍历集合，判读是否有TextView内容是空的
        // 注意：Java中，集合，数组，都是从第0个元素开始遍历
        for (int i = 0; i < textViews.size(); i++) {
            // 拿到集合中第i个TextView，0～4
            TextView textView = textViews.get(i);
            // 通过TextUtils判断TextView中的内容是否为空
            if (TextUtils.isEmpty(textView.getText())) {
                textView.setText(content);
                // 跳出当前for循环
                break;
            }
        }
    }
}
