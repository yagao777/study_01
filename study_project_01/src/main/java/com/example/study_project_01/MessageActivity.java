package com.example.study_project_01;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.study_project_01.Model.MessageModel;
import com.example.study_project_01.event.UpdateUserEvent;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

//    final Context context = this;
    private TextView tv_img;
    private TextView tv_username;
    private TextView tv_introduce;
    private TextView tv_sex;
    private TextView tv_birth;
    private TextView tv_area;

    private TextView tv_et_username;
    private TextView tv_et_introduce;
    private TextView tv_et_birth;

    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private MessageSQLiteOpenHelper dbHelper1;
    private SQLiteDatabase sqLiteDatabase1;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    private MessageModel messageModel = new MessageModel();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        tv_img = findViewById(R.id.tv_img);
        tv_username = findViewById(R.id.tv_username);
        tv_introduce = findViewById(R.id.tv_introduce);
        tv_sex = findViewById(R.id.tv_sex);
        tv_birth = findViewById(R.id.tv_birth);
        tv_area = findViewById(R.id.tv_area);

        tv_et_username = findViewById(R.id.tv_et_username);
        tv_et_introduce = findViewById(R.id.tv_et_introduce);
        tv_et_birth = findViewById(R.id.tv_et_birth);

        tv_img.setOnClickListener(this);
        tv_username.setOnClickListener(this);
        tv_introduce.setOnClickListener(this);
        tv_sex.setOnClickListener(this);
        tv_birth.setOnClickListener(this);
        tv_area.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        dbHelper1 = new MessageSQLiteOpenHelper(getApplicationContext(), "test_carson");
        sqLiteDatabase1 = dbHelper1.getWritableDatabase();

        System.out.println("查询数据");

        // 一般情况下，这个id应该是从上个页面通过intent传递进来的，
        String id = "1";

        Cursor cursor = sqLiteDatabase1.query("user", new String[]{"id",
                "name", "introduce", "birth"}, "id = ?", new String[]{id}, null, null, null);

//        int userId = 0;
//        String name = null;
//        String introduce = null;
//        long birth = 0;

        //      select * from User where id = ?, name = ?
        //      String[]{"1", "hhh"}

        if (cursor.moveToNext()) {
            int userId = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
            long birth = cursor.getLong(cursor.getColumnIndex("birth"));

            messageModel.setUserId(userId);
            messageModel.setName(name);
            messageModel.setIntroduce(introduce);
            messageModel.setBirth(birth);

            Log.d("yagao", "userId:" + userId + "name:" + name + "introduce:" + introduce + "birth:" + birth);
            cursor.close();

            tv_et_username.setText(name);
            tv_et_introduce.setText(introduce);

            if (birth > 0) {
                Date date = new Date();
                date.setTime(birth);
                tv_et_birth.setText(dateFormat.format(date));
            }

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tv_username:

                // this 就是context
                LayoutInflater li_username = LayoutInflater.from(this);
                View usernameView = li_username.inflate(R.layout.username_alertdaialog, null);
                AlertDialog.Builder usernameBuilder = new AlertDialog.Builder(this);
                usernameBuilder.setView(usernameView);
                final EditText usernameInput = usernameView.findViewById(R.id.ad_information);
                usernameInput.setHint("请输入您想要修改的昵称");

                usernameBuilder
                        .setCancelable(false)
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        String content = usernameInput.getText().toString();
                                        messageModel.setName(content);
                                        tv_et_username.setText(content);
//                                        if (!hasRecord) {
//
//                                            // insert
//                                            tv_et_username.setText(content);
//
//
//                                        } else {
//                                            // 更新
//                                            System.out.println("修改数据");
//                                            tv_et_username.setText(content);
//
//                                            ContentValues values2 = new ContentValues();
////                                        values2.put("name", "zhangsan");
//                                            values2.put("name", content);
//
//                                            // 调用update方法修改数据库
////                sqliteDatabase2.update("user", values2, "id=?", new String[]{"1"});
//
////                                            sqLiteDatabase1.update("user", values2, "id=?", new String[]{"1"});
//                                            messageModel.setUsername(tv_et_username.getText().toString());
//                                        }
                                        //关闭数据库
//                                        sqLiteDatabase1.close();
                                        // 发射事件
//                                        UpdateUserEvent.sendEvent(new UpdateUserEvent(content));
                                    }
                                })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertUsername = usernameBuilder.create();
                alertUsername.show();

                break;

            case R.id.tv_introduce:

                LayoutInflater li_introduce = LayoutInflater.from(this);
                View introduceView = li_introduce.inflate(R.layout.username_alertdaialog, null);
                AlertDialog.Builder introduceBuilder = new AlertDialog.Builder(this);
                introduceBuilder.setView(introduceView);
                final EditText introduceInput = introduceView.findViewById(R.id.ad_information);
                introduceInput.setHint("请输入您想要修改的介绍");
                introduceBuilder
                        .setCancelable(false)
                        .setPositiveButton("确定",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
//                                        if (!hasRecord) {
//                                            String content = introduceInput.getText().toString();
//                                            tv_et_introduce.setText(content);
//                                            messageModel.setIntroduce(content);
//
//                                        } else {
//                                            String content = introduceInput.getText().toString();
//                                            tv_et_introduce.setText(content);
//                                            System.out.println("修改介绍数据");
//
//                                            ContentValues values2 = new ContentValues();
//                                            values2.put("introduce", content);
//
////                                            sqLiteDatabase1.update("user", values2, "id=?", new String[]{"1"});
//                                            messageModel.setIntroduce(tv_et_introduce.getText().toString());
//
//                                        }

                                        String content = introduceInput.getText().toString();
                                        tv_et_introduce.setText(content);
                                        messageModel.setIntroduce(tv_et_introduce.getText().toString());

//                                        sqLiteDatabase1.close();
                                    }
                                })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertIntroduce = introduceBuilder.create();
                alertIntroduce.show();

                break;

            case R.id.tv_sex:
                final String[] sexs = new String[]{"男", "女", "未知"};
                alert = null;
                builder = new AlertDialog.Builder(this);
                alert = builder
                        .setTitle("请选择您的性别")
                        .setSingleChoiceItems(sexs, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "你选择了" + sexs[which], Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
                break;

            case R.id.tv_birth:



                LayoutInflater li_birth = LayoutInflater.from(this);
                View birthView = li_birth.inflate(R.layout.birth_dialog, null);
                final DatePicker datePicker = birthView.findViewById(R.id.DatePicker_birth);

                final Calendar calendar = Calendar.getInstance();

                Button ok = birthView.findViewById(R.id.button_student_mydialog);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // 一般用这种方式，给AlertDialog设置View，
                // 不建议用这种： dialog.getWindow().setContentView(birthView)
                builder.setView(birthView);

                datePicker.init(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                            @Override
                            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                                calendar.set(i, i1, i2);
                                messageModel.setBirth(calendar.getTimeInMillis());
                                String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
                                tv_et_birth.setText(date);
                            }
                        });
                final AlertDialog dialog = builder.create();

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
                        dialog.dismiss();
                        messageModel.setBirth(calendar.getTimeInMillis());
                        String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
                        tv_et_birth.setText(date);
                    }
                });

                dialog.show();






//                final AlertDialog dialog = new AlertDialog.Builder(this).create();
//                dialog.show();
//                LayoutInflater li_birth = LayoutInflater.from(context);
//                View birthView = li_birth.inflate(R.layout.birth_dialog, null);
//                dialog.getWindow().setContentView(birthView);
//                //dialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM);//设置Dialog现实的位置
//                final DatePicker datePicker = dialog.getWindow().findViewById(R.id.DatePicker_birth);
//                final Calendar calendar = Calendar.getInstance();
//                datePicker.init(calendar.get(Calendar.YEAR),
//                        calendar.get(Calendar.MONTH),
//                        calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
//                            @Override
//                            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//                                calendar.set(i, i1, i2);
//                                messageModel.setBirth(calendar.getTimeInMillis());
//                                String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
//                                tv_et_birth.setText(date);
//                            }
//                        });
//
//
//                Button ok = birthView.findViewById(R.id.button_student_mydialog);
//
//                ok.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
//                        dialog.dismiss();
//                        messageModel.setBirth(calendar.getTimeInMillis());
//                        String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
//                        tv_et_birth.setText(date);
//                        long timeInMillis = calendar.getTimeInMillis();

//                        if (!hasRecord) {
////                            String content = datePicker.getText().toString();
//                            long timeInMillis = calendar.getTimeInMillis();
//
//                            String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
//
////                            tv_et_birth.setText((int) timeInMillis);
//                            tv_et_birth.setText(date);
//
//                            messageModel.setBirth(timeInMillis);
//
//
//                        } else {
////                            String content = DatePicker_birth.getText().toString();
//                            long timeInMillis = calendar.getTimeInMillis();
//
//                            String date = "" + datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth();
//
//                            tv_et_birth.setText(date);
//                            System.out.println("修改生日数据");
//
//                            ContentValues values2 = new ContentValues();
//                            values2.put("birth", timeInMillis);
//
////                            sqLiteDatabase1.update("user", values2, "id=?", new String[]{"1"});
////                            messageModel.setBirth(tv_et_birth.getText().length());
//                            messageModel.setBirth(calendar.getTimeInMillis());
//
//                        }
//                    }
//                });

//                AlertDialog.Builder birthBuilder = new AlertDialog.Builder(context);
//                birthBuilder.setView(birthView);
//
//                dialog.getWindow().findViewById(R.id.button_student_mydialog).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        StringBuilder sb = new StringBuilder();
//                        sb.append(
//                                String.format(Locale.getDefault(), "%d-%02d-%02d",
//                                        datePicker.getYear(),
//                                        datePicker.getMonth() + 1,
//                                        datePicker.getDayOfMonth()));
//                        Log.i("borndate_sb", sb.toString() + "");
//                        tv_et_birth.setText(sb.toString());
//                        dialog.dismiss();
//                    }
//                });
//                birthBuilder
//                        .setCancelable(false)
//                        .setPositiveButton("确定",
//                                new DialogInterface.OnClickListener() {
//                                    public void onClick(DialogInterface dialog, int id) {
//                                        if (!hasRecord) {
//                                            String content = DatePicker_birth.getText().toString();
//                                            tv_et_birth.setText(content);
//                                            System.out.println("插入生日数据");
//
//                                            ContentValues values1 = new ContentValues();
//                                            values1.put("birth", content);
//
//                                            sqLiteDatabase1.insert("user", null, values1);
//
//                                        } else {
//                                            String content = DatePicker_birth.getText().toString();
//                                            tv_et_introduce.setText(content);
//                                            System.out.println("修改生日数据");
//
//                                            ContentValues values2 = new ContentValues();
//                                            values2.put("birth", content);
//
//                                            sqLiteDatabase1.update("user", values2, "id=?", new String[]{"1"});
//
//                                        }
//
////                                        sqLiteDatabase1.close();
//
//                                    }
//
//                                });

        }

    }

    @Override
    public void onBackPressed() {
        System.out.println("插入数据");

        ContentValues values1 = new ContentValues();
        values1.put("name", messageModel.getName());

//        sqLiteDatabase1.insert("user", null, values1);

        System.out.println("插入介绍数据");

//        ContentValues values1 = new ContentValues();
        values1.put("introduce", messageModel.getIntroduce());

//        sqLiteDatabase1.insert("user", null, values1);

        System.out.println("插入生日数据");

//        ContentValues values1 = new ContentValues();
        values1.put("birth", messageModel.getBirth());

        if (messageModel.getUserId() > 0) {
            String id = String.valueOf(messageModel.getUserId());
            sqLiteDatabase1.update("user", values1, "id=?", new String[]{id});
        } else {
            sqLiteDatabase1.insert("user", null, values1);
        }

        // 在真正修改时，才发送更新事件
        UpdateUserEvent.sendEvent(new UpdateUserEvent(messageModel.getName()));

        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sqLiteDatabase1.close();
    }
}
