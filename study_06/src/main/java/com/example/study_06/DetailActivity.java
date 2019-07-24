package com.example.study_06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

public class DetailActivity extends AppCompatActivity {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    private ImageView ivImg2;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextView tvTime2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivImg2 = findViewById(R.id.iv_img2);
        tvTitle = findViewById(R.id.tv_title);
        tvSubtitle = findViewById(R.id.tv_subtitle);
        tvTime2 = findViewById(R.id.tv_time2);

        MyModel model= getIntent().getParcelableExtra("entity");
        tvTitle.setText(model.getTitle());
        tvSubtitle.setText(model.getSubTitle());
        Glide.with(this).load(model.getUrl()).into(ivImg2);
        tvTime2.setText(format.format(model.getTime()));
    }
}
