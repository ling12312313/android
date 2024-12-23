package com.example.sqlitestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStorage1;
    Button btnStorage2;
    Button btnXml;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStorage1 = findViewById(R.id.btnExter);
        btnStorage1.setOnClickListener(this);

        btnStorage2 = findViewById(R.id.btnInter);
        btnStorage2.setOnClickListener(this);

        btnXml = findViewById(R.id.btnXml);
        btnXml.setOnClickListener(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExter:
                Intent intent = new Intent(this,StorageActivity.class);
                startActivity(intent);
                break;
            case R.id.btnInter:
                Intent intent2 = new Intent(this,Storage2Activity.class);
                startActivity(intent2);
                break;
            case R.id.btnXml:
                Intent intent3 = new Intent(this,XMLStorageActivity.class);
                startActivity(intent3);
                break;

            case R.id.btnLogin:
                Intent intent4 = new Intent(this,LoginActivity.class);
                startActivity(intent4);
                break;
        }
    }
}
