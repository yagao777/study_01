package com.example.study_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_test;

    private List<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);
        Button btn_content = findViewById(R.id.btn_content);
        btn_content.setOnClickListener(this);

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
        String content = et_test.getText().toString();
        et_test.getText().clear();

        for (int i = 0;i < textViews.size();i++) {
            TextView textView = textViews.get(i);
            if (TextUtils.isEmpty(textView.getText())){
                textView.setText(content);
                break;
            }
        }
    }
}
