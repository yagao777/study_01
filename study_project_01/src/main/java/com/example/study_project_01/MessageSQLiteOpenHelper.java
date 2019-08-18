package com.example.study_project_01;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MessageSQLiteOpenHelper extends SQLiteOpenHelper {

    private static Integer Version = 1;

//    public MessageSQLiteOpenHelper(Context context, String name, int version) {
//        super(context, name, null, version);
//    }

    public MessageSQLiteOpenHelper(Context context, String name) {
        super(context, name,null, Version);
    }

//    public MessageSQLiteOpenHelper(Context context, String name, int version, SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        System.out.println("创建数据库和表");
        String sql = "create table user(id INTEGER primary key autoincrement,name varchar(200),introduce varchar(200),sex int,birth datatime,area varchar(200))";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        System.out.println("更新数据库版本为:" + i1);

    }
}
