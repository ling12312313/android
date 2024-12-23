package com.example.sqlitestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Storage2Activity extends AppCompatActivity {
    private static final String TAG = "Storage2Activity";
    Button btnSave;
    Button btnLoad;
    EditText etCnt;
    TextView tvCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);
        etCnt = findViewById(R.id.etCnt);
        etCnt.setText("");
        tvCnt = findViewById(R.id.txtShowCnt);
    }


    public void operate(View view) {
        File file =new File(getFilesDir(),"myfile.txt");
        switch (view.getId()) {
            case R.id.btnSave:

                try {
                    if(!file.exists()){
                        file.createNewFile();
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(etCnt.getText().toString().getBytes());
                    fos.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                break;
            case R.id.btnLoad:
                try {
                    FileInputStream fis = new FileInputStream(file);
                    byte[] b =new byte[1024];
                    int len = fis.read(b);
                    String cnt = new String(b,0,len);
                    tvCnt.setText(cnt);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                break;
        }

    }

}
