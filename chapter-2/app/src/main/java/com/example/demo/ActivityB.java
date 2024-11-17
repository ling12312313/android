package com.example.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityb);
        Log.i("TAG", "onCreate:B");
    }
    @Override
    public void finish() {
        super.finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStartB");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG","onResumeB");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG","onPauseB");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG","onStopB");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","onDestroyB");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG","onRestartB");
    }
}
