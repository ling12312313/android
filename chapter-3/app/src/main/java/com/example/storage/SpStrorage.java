package com.example.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SpStrorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sp_strorage);

    }

    public void spStrorage(View view) {
        SharedPreferences mySp = getSharedPreferences("mySp", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = mySp.edit();
        edit.putString("name", "ling");
        edit.putInt("age", 18);
        edit.apply();
        Toast.makeText(SpStrorage.this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    public void spRead(View view) {
        SharedPreferences mySp = getSharedPreferences("mySp", Context.MODE_PRIVATE);
        String user = mySp.getString("name", "");
        int age = mySp.getInt("age", 0);
        Toast.makeText(SpStrorage.this, "name:" + user + "age:" + age, Toast.LENGTH_SHORT).show();
    }
}