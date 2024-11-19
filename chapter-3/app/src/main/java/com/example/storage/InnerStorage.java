package com.example.storage;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InnerStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_innerstorage);

    }

    public void innerStorage(View view) throws IOException {
        FileOutputStream fos = openFileOutput("data.txt", MODE_PRIVATE);
        fos.write(" i am ling ".getBytes());
        fos.close();
        Toast.makeText(InnerStorage.this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    public void innerRead(View view) throws IOException {
        FileInputStream fileOutputStream = openFileInput("data.txt");
        byte[] bytes = new byte[fileOutputStream.available()];
        fileOutputStream.read(bytes);
        Toast.makeText(InnerStorage.this, new String(bytes), Toast.LENGTH_SHORT).show();
    }
}