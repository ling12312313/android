package com.example.sqlitestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {


    public MyHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //定义建表语句
        String sql = "CREATE TABLE Student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + // 自增主键
                "name TEXT NOT NULL);";                   // 名字字段，不允许为空

        //执行SQL语句
        db.execSQL(sql);
        initData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
   public void initData(SQLiteDatabase db){
       ContentValues values = new ContentValues();
       values.put("name","zhangsan");
       db.insert("Student", null, values);
       values.put("name", "lisi");
       db.insert("Student", null, values);
       values.put("name", "wangwu");
       db.insert("Student", null, values);
       values.put("name", "zhaoliu");
       db.insert("Student", null, values);
   }
}
