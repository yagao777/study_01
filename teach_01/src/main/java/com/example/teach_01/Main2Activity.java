package com.example.teach_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public static final String MY_DATA_FLAG2 = "MyData2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // 拿到MainActivity传递过来的数据
        String data = getIntent().getStringExtra(MainActivity.MY_DATA_FLAG);
        TextView tv_center = findViewById(R.id.tv_center);

        // 设置到TextView中进行显示
        tv_center.setText(data);
    }

    // 绑定按钮的点击事件有两种方式，一种设置一个监听器，setOnClickListener
    // 另一种是在布局文件中直接绑定, 对应布局的android:onClick
    public void returnPre(View view) {
        Intent intent = new Intent();
        intent.putExtra(MY_DATA_FLAG2, "你好世界");

        // 设置ResultCode为RESULT_OK，用来表示传回去的数据
        setResult(RESULT_OK, intent);

        // 结束当前的Activity
        finish();
    }
}
