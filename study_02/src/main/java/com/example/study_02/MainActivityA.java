package com.example.study_02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityA extends AppCompatActivity implements View.OnClickListener {

    private TextView bottom_tv;

    public static final int REQUEST_CODE = 1;

    public static final String MY_DATA_FLAG =  "MyData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        Button btn_jump = findViewById(R.id.btn_jump);

        bottom_tv = findViewById(R.id.bottom_tv);

        btn_jump.setOnClickListener(this);
    }

    // 点击事件回调
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivityB.class);

        intent.putExtra(MY_DATA_FLAG, "hello world...");

        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String resultData = data.getStringExtra(MainActivityB.MY_DATA_FLAG2);

            bottom_tv.setText(resultData);
        }
    }
}
