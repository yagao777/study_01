package com.example.teach_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText userNameEt;
    private EditText passwordEt;

    // 我们全局多个地方都要用到，所以这里直接声明为成员变量，这样只需在一个地方给它赋值，那么其他地方就可以使用了
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.btn_login);
        userNameEt = findViewById(R.id.et_user_name);
        passwordEt = findViewById(R.id.et_user_password);

        loginBtn.setOnClickListener(this);

        // 赋一次值即可，其他地方不需要再重复这个操作
        sharedPreferences = getSharedPreferences(Config.TANG_POETRY_SP, MODE_PRIVATE);

        String userName = sharedPreferences.getString(Config.USER_NAME, "");
        String password = sharedPreferences.getString(Config.USER_PWD, "");

        // 如果之前登录过，并且输入了用户名为"杜甫"，密码为"123456",就不需要再进行登录，直接结束当前页面，跳到MainActivity
        if ("杜甫".equals(userName) && "123456".equals(password)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        // 用户点击登录，先判断用户名是否为"杜甫"，密码是否为"123456"，如果是，则保存到sharedPreferences，
        // 并跳转到MainActivity,结束当前页面
        // 否则，弹出Toast，提示用户名或密码错误
        String userName = userNameEt.getText().toString();
        String password = passwordEt.getText().toString();

        // ...
    }
}
