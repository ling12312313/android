package com.example.sqlitestorage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StorageActivity extends AppCompatActivity {

    private static final String TAG = "StorageActivity";
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

        int permisson = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(permisson!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (1==requestCode){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "权限已授予！", Toast.LENGTH_SHORT).show();
            } else {
                // 权限被拒绝，提示用户
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "请授予存储权限以保存文件！", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "权限被拒绝且不再提示，请在设置中手动授予权限！", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void operate(View view) {
       // String path = Environment
        String environment=Environment.getExternalStorageState();
        switch (view.getId()){
            case R.id.btnSave:
                if(Environment.MEDIA_MOUNTED.equals(environment)) {
                    //外部设备可以进行读写操作
                    File sd_path=Environment.getExternalStorageDirectory();
                    //if (!sd_path.exists())  {return;}
                    File file=new File(sd_path,"testfile.txt");
                    Log.d(TAG, "operate: "+file.getAbsolutePath());
                    String str= etCnt.getText().toString();
                    FileOutputStream fos;
                    try{
                        //写入数据
                        fos=new FileOutputStream(file);
                        OutputStreamWriter osw=new OutputStreamWriter(fos);
                        osw.write(str);
                        osw.flush();
                        osw.close();
                        fos.close();
                    }
                    catch(Exception exception){
                        exception.printStackTrace();
                    }
                }
                Toast.makeText(this,"保存成功！",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnLoad:
                if(Environment.MEDIA_MOUNTED.equals(environment)) {
                    //外部设备可以进行读写操作
                    File sd_path=Environment.getExternalStorageDirectory();
                    //if (!sd_path.exists()) {return; }
                    File file=new File(sd_path,"testfile.txt");
                    FileInputStream fis;
                    try{
                        //读取文件
                        fis=new FileInputStream(file);
                        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
                        char[] input=new char[fis.available()];
                        isr.read(input);
                        String cnt = new String(input);
                        Log.d(TAG, "operate: "+cnt);
                        tvCnt.setText(cnt);
                        isr.close();
                        fis.close();
                    }
                    catch(Exception exception){
                        exception.printStackTrace();
                    }
                }
                Toast.makeText(this,"读取成功！",Toast.LENGTH_LONG).show();

                break;
        }
    }
}
