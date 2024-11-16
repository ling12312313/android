package com.example.demo1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity2 extends AppCompatActivity {
    private  TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.acticity_alertdialog2);
        textView = findViewById(R.id.text);
    }

    private String[] SizeArr = {"小号","中号","大号","超大号"};
    private int index;
    private int size[] = {10,20,30,40,50};


    public void showSingleChoice(View view) {
        new AlertDialog.Builder(this).setTitle("请选择字体大小")
                .setSingleChoiceItems(SizeArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        index = i;
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     textView.setTextSize(size[index]);
                    }
                }).setNegativeButton("取消",null)
                .create().show();
    }
}
