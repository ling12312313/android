package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        Log.i("TAG", "onCreate: A");
    }
    public void jumpB(View view){
        Intent intent = new Intent(this,ActivityB.class);
        startActivity(intent);
    }

    public void displayInfo(View view) {
        Intent intent = new Intent(this,ActivityC.class);
        Bundle bundle = new Bundle();
        bundle.putString("name", "张三");
        bundle.putInt("age", 21);
        intent.putExtras(bundle);
        startActivityForResult(intent,101);
     }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 一个是返回的数据代号，另一个是返回的状态是否正常
        //注意这俩个不一样，太坑了
        if (requestCode == 101 && resultCode==RESULT_OK){
            Toast.makeText(Activity.this,data.getStringExtra("info"),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStartA");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","onResumeA");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","onPauseA");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","onStopA");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","onDestroyA");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG","onRestartA");
    }

}