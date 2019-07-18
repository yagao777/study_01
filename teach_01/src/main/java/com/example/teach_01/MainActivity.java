package com.example.teach_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView bottom_tv;

    // 作用是用来在MainActivity和Main2Activity之间跳转时，用来标识的，可以任意值
    public static final int REQUEST_CODE = 1;

    // 用来标识传递过去的数据
    public static final String MY_DATA_FLAG = "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这里对应的是res文件夹下的layout文件夹的activity_main.xml 布局文件
        // 表示将MainActivity与布局文件绑定
        setContentView(R.layout.activity_main);

        // 拿到xml文件中声明的控件
        Button btn_jump = findViewById(R.id.btn_jump);

        // 声明为成员变量，这样才能够类的全局中获取
        bottom_tv = findViewById(R.id.bottom_tv);
        // 添加Button的点击事件监听
        btn_jump.setOnClickListener(this);
    }


    // 点击事件回调
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra(MY_DATA_FLAG, "hello world");

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 通过resultCode可以标识Main2Activity返回的数据，用RESULT_OK表示数据是正常的

        // requestCode的作用用来标识跳转到其他页面的目的：
        // 比如：我们传1 ，表示跳到Main2Activity页面获取数据
        // 我们传2 ，表示跳到XXXActivity页面获取数据，当从它们结束，返回数据回来，通过这个requestCode我们就能
        // 知道是从哪个页面返回的
        // 通过resultCode也是可以进行标识
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            // 表明我们是从Main2Activity返回的，我们可以拿到Main2Activity的数据
            String resultData = data.getStringExtra(Main2Activity.MY_DATA_FLAG2);

            // 拿到成员变量bottom_tv
            bottom_tv.setText(resultData);
        }
    }
}
