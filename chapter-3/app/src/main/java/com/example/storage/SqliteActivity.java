package com.example.storage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storage.databinding.ActivitySqliteBinding;

public class SqliteActivity extends AppCompatActivity {
     private SQLiteDatabase db;
     private ActivitySqliteBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        此项目尚未完成，使用课本上的案例重做
        super.onCreate(savedInstanceState);
        binding = ActivitySqliteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyHeler myHeler = new MyHeler(this, "user.db", null, 1);
        db = myHeler.getWritableDatabase();
    }

    public void addUser(View view) {
        String name = binding.nameEt.getText().toString().trim();
        String phone = binding.phoneEt.getText().toString().trim();
        if(name.isEmpty() || phone.isEmpty()){
            Toast.makeText(this,"name or phone is empty" , Toast.LENGTH_SHORT).show();
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);
        db.insert("user",null,contentValues);
    }

}
