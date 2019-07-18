package com.example.study_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityB extends AppCompatActivity {

    public static final String MY_DATA_FLAG2 = "MyData2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        String data = getIntent().getStringExtra(MainActivityA.MY_DATA_FLAG);

        TextView tv_center = findViewById(R.id.tv_center);

        tv_center.setText(data);
    }

    public void returnPre(View view) {
        Intent intent = new Intent();
        intent.putExtra(MY_DATA_FLAG2,"你好，世界ya");
        setResult(RESULT_OK,intent);

        finish();
    }
}
