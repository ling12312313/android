package com.example.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyHeler extends SQLiteOpenHelper {


    public MyHeler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "ling.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        创建数据库db
        String sql = "create table user(id integer primary key autoincrement,name varchar(10),phone integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
