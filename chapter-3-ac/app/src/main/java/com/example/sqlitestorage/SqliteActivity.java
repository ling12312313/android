package com.example.sqlitestorage;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SqliteActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        MyHelper myHelper = new MyHelper(this, "student.db", null, 1);
        SQLiteDatabase db = myHelper.getReadableDatabase();
        List<String> students = new ArrayList<>();
        Cursor cursor= db.query("Student", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                students.add(name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.simple_list_item,students);
        ListView listView = (ListView) findViewById(R.id.mylist);
        listView.setAdapter(adapter);
    }
}
