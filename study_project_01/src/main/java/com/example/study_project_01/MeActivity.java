package com.example.study_project_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MeActivity extends AppCompatActivity{

    private Button userinfBtn;
    private TextView tv_setting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        userinfBtn = findViewById(R.id.btn_user_info);
        tv_setting = findViewById(R.id.tv_setting);

        userinfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this, UserinfoActivity.class);

                startActivity(intent);

            }
        });


        tv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MeActivity.this, SettingActivity.class);

                startActivity(intent);
            }
        });

    }


}
