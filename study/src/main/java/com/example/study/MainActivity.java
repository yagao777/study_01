package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_1 = findViewById(R.id.iv_1);
        // 在代码中设置控件的属性，能够更加灵活的根据需求进行变化
        // 在代码中进行设置对应的属性，一般可以根据其在xml中的名字，找到对应的设置方法
        // android:scaleType="centerCrop"
        iv_1.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView tv_title1 = findViewById(R.id.tv_title1);
        // android:textSize="16sp"
        tv_title1.setTextSize(16);
        // android:textColor="@android:color/black"
        tv_title1.setTextColor(getResources().getColor(android.R.color.black));

        TextView tv_sub_title1 = findViewById(R.id.tv_sub_title1);
        // android:textSize="16sp"
        tv_sub_title1.setTextSize(12);
        // android:textColor="@android:color/black"
        tv_sub_title1.setTextColor(getResources().getColor(android.R.color.darker_gray));
    }
}
