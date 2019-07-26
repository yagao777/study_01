package com.example.study_08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.study_08.LoginActivity.Config.USER_NAME;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText userNameEt;
    private EditText passwordEt;

    private SharedPreferences sharedPreferences;
//    private final static String SP_LOGIN = "sp_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.btn_login);
        userNameEt = findViewById(R.id.et_user_name);
        passwordEt = findViewById(R.id.et_user_password);

        loginBtn.setOnClickListener(this);

        sharedPreferences = getSharedPreferences(Config.TANG_POETRY, MODE_PRIVATE);

        String userName = sharedPreferences.getString(Config.USER_NAME, "");
        String password = sharedPreferences.getString(Config.USER_PWD, "");

        // 如果之前登录过，并且输入了用户名为"杜甫"，密码为"123456",就不需要再进行登录，直接结束当前页面，跳到MainActivity
        if ("杜甫".equals(userName) && "123456".equals(password)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }

    public interface Config {
        String TANG_POETRY = "tang_poetry";
        String USER_NAME = "user_name";
        String USER_PWD = "user_pwd";
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                String userName = userNameEt.getText().toString();
                String password = passwordEt.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences(Config.TANG_POETRY, LoginActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if ("杜甫".equals(userName) && "123456".equals(password)) {
                    editor.putString(Config.USER_NAME, userName);
                    editor.putString(Config.USER_PWD, password);
                    editor.commit();
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("entity", "");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
