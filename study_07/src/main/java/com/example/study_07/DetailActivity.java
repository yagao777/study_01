package com.example.study_07;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

public class DetailActivity extends AppCompatActivity {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


    private ImageView ivImg2;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextView tvTime2;
    private EditText etName;

    MyModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = getSharedPreferences("et_name", DetailActivity.MODE_PRIVATE);

        ivImg2 = findViewById(R.id.iv_img2);
        tvTitle = findViewById(R.id.tv_title);
        tvSubtitle = findViewById(R.id.tv_subtitle);
        tvTime2 = findViewById(R.id.tv_time2);
        etName = findViewById(R.id.et_name);

        model = getIntent().getParcelableExtra("entity");
        etName.setText(sharedPreferences.getString("name" + model.getTitle().hashCode(), ""));
        tvTitle.setText(model.getTitle());
        tvSubtitle.setText(model.getSubTitle());
        Glide.with(this).load(model.getUrl()).into(ivImg2);
        tvTime2.setText(format.format(model.getTime()));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        SharedPreferences sharedPreferences = getSharedPreferences("et_name", DetailActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name" + model.getTitle().hashCode(), etName.getText().toString());
        editor.commit();

        switch (item.getItemId()) {
            case R.id.id_preserve:
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
