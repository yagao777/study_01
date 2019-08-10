package com.example.study_project_01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_lema_bind;
    private ImageView iv_lema_icon;
    private TextView tv_wechat_bind;
    private ImageView iv_wechat_icon;
    private TextView tv_language;
//    private Context mContext;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    private boolean lemaBinded = false;
    private boolean unlemaBinded = true;

    private boolean wechatBinded = true;
    private boolean unwechatBinded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
//        mContext = SettingActivity.this;
        bindView();
    }

    private void bindView() {
        tv_lema_bind = findViewById(R.id.tv_lema_bind);
        iv_lema_icon = findViewById(R.id.iv_lema_icon);
        tv_lema_bind.setOnClickListener(this);
        tv_wechat_bind = findViewById(R.id.tv_wechat_bind);
        iv_wechat_icon = findViewById(R.id.iv_wechat_icon);
        tv_wechat_bind.setOnClickListener(this);
        tv_language = findViewById(R.id.tv_language);
        tv_language.setOnClickListener(this);

        bindlema();
        unbindwechat();

    }

    private void bindlema() {
        if (lemaBinded) {
            tv_lema_bind.setBackgroundResource(R.drawable.shape_setting_unbind_bg);
            tv_lema_bind.setText("解绑");
            tv_lema_bind.setTextColor(getResources().getColor(R.color.bind_black_color));
            iv_lema_icon.setImageResource(R.drawable.ic_login_lema);
        } else {
            tv_lema_bind.setBackgroundResource(R.drawable.shape_setting_bind_bg);
            tv_lema_bind.setText("绑定");
            tv_lema_bind.setTextColor(getResources().getColor(android.R.color.white));
            iv_lema_icon.setImageResource(R.drawable.lema_nobind);
        }
    }

    private void unbindlema() {
        if (unlemaBinded) {
            tv_lema_bind.setBackgroundResource(R.drawable.shape_setting_bind_bg);
            tv_lema_bind.setText("绑定");
            tv_lema_bind.setTextColor(getResources().getColor(android.R.color.white));
            iv_lema_icon.setImageResource(R.drawable.lema_nobind);
        } else {
            tv_lema_bind.setBackgroundResource(R.drawable.shape_setting_unbind_bg);
            tv_lema_bind.setText("解绑");
            tv_lema_bind.setTextColor(getResources().getColor(R.color.bind_black_color));
            iv_lema_icon.setImageResource(R.drawable.ic_login_lema);
        }
    }

    private void bindwechat() {
        if (wechatBinded) {
            tv_wechat_bind.setBackgroundResource(R.drawable.shape_setting_unbind_bg);
            tv_wechat_bind.setText("解绑");
            tv_wechat_bind.setTextColor(getResources().getColor(R.color.bind_black_color));
            iv_wechat_icon.setImageResource(R.drawable.no_bind_wechat);
        } else {
            tv_wechat_bind.setBackgroundResource(R.drawable.shape_setting_bind_bg);
            tv_wechat_bind.setText("绑定");
            tv_wechat_bind.setTextColor(getResources().getColor(android.R.color.white));
            iv_wechat_icon.setImageResource(R.drawable.already_bind_wechat);
        }
    }

    private void unbindwechat() {
        if (unwechatBinded) {
            tv_wechat_bind.setBackgroundResource(R.drawable.shape_setting_bind_bg);
            tv_wechat_bind.setText("绑定");
            tv_wechat_bind.setTextColor(getResources().getColor(android.R.color.white));
            iv_wechat_icon.setImageResource(R.drawable.already_bind_wechat);
        } else {
            tv_wechat_bind.setBackgroundResource(R.drawable.shape_setting_unbind_bg);
            tv_wechat_bind.setText("解绑");
            tv_wechat_bind.setTextColor(getResources().getColor(R.color.bind_black_color));
            iv_wechat_icon.setImageResource(R.drawable.no_bind_wechat);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //普通对话框
            case R.id.tv_lema_bind:
                alert = null;
                builder = new AlertDialog.Builder(this);
                alert = builder
                        .setTitle("绑定：")
                        .setMessage("确定要绑定乐马账号吗？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this, "取消绑定", Toast.LENGTH_SHORT).show();
                                unlemaBinded = true;
                                unbindlema();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this, "绑定成功", Toast.LENGTH_SHORT).show();
                                lemaBinded = true;
                                bindlema();
                            }
                        }).create();             //创建AlertDialog对象
                alert.show();                    //显示对话框
                break;

            case R.id.tv_wechat_bind:
                alert = null;
                builder = new AlertDialog.Builder(this);
                alert = builder
                        .setTitle("解绑：")
                        .setMessage("确定要解绑微信吗？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this, "解绑取消", Toast.LENGTH_SHORT).show();
                                unwechatBinded = true;
                                unbindwechat();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SettingActivity.this, "解绑成功", Toast.LENGTH_SHORT).show();
                                wechatBinded = true;
                                bindwechat();
                            }
                        }).create();             //创建AlertDialog对象
                alert.show();                    //显示对话框
                break;

            case R.id.tv_language:
                final String[] languages = new String[]{"简体中文", "繁体中文", "英语"};
                alert = null;
                builder = new AlertDialog.Builder(this);
                alert = builder
                        .setTitle("请选择你喜欢语言")
                        .setSingleChoiceItems(languages, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "你选择了" + languages[which], Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
                break;
        }

    }

}
