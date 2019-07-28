package com.example.teach_09;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.teach_09.model.MyModel;

import java.text.SimpleDateFormat;

public class DetailActivity extends AppCompatActivity {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


    private ImageView ivImg2;
    private TextView tvTitle;
    private TextView tvSubtitle;
    private TextView tvTime2;
    private EditText etName;

    private final static String SP_DETAIL = "sp_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ivImg2 = findViewById(R.id.iv_img2);
        tvTitle = findViewById(R.id.tv_title);
        tvSubtitle = findViewById(R.id.tv_subtitle);
        tvTime2 = findViewById(R.id.tv_time2);
        etName = findViewById(R.id.et_name);

        // 这里第一个参数指的是保存的所用的sp文件的名字，一般是全局唯一的，所以应该定义一个全局常量来使用
        // 以后在开发，一般sp文件只会有一个，这里放在这里是为了方便简单使用，正常情况下，会写一个工具类来管理
        SharedPreferences sharedPreferences = getSharedPreferences(SP_DETAIL, DetailActivity.MODE_PRIVATE);
        // sp保存数据是通过key-value，键值对的方式来进行保存，保存内容的时候，我们需要为内容设置一个键(key)来保存，
        // 这里的"name"就是一个键
        // 为什么点击进来就会崩呢？ 因为你这里把etName写在了etName = findViewById(R.id.et_name);之前
        // 需要先拿到etName实例，才能使用它的setText
        etName.setText(sharedPreferences.getString("et_name", ""));


        MyModel model = getIntent().getParcelableExtra("entity");
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

        switch (item.getItemId()) {
            // 应该是在点击"保存"菜单时，保存内容，
            // 每次点击菜单时，onOptionsItemSelected方法都会被调用，我们通过菜单的id来区分是点击了什么菜单
            // 这里点击的是id为R.id.id_preserve的菜单
            case R.id.id_preserve:
                // 点击保存菜单，就会走这个分支，所以应该把保存操作放在这里！！！
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

                // 拿到名为sp_detail的sp文件实例
                SharedPreferences sharedPreferences = getSharedPreferences(SP_DETAIL, DetailActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // 注意，你这里定义的键为et_name ,上面你在拿的时候就应该使用et_name,而不是name
                // 保存的内容应该是EditText的内容
                editor.putString("et_name", etName.getText().toString());
                editor.commit();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
