package com.example.demo1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alertdialog3);
    }
    private String wuJiang[] = {"荀彧","陆逊","孙寒华","貂蝉","张松"};
    private boolean isCheck[]= new boolean[]{false,false,false,false,false};
    public void showMultiChoiceDialog(View view) {
         new AlertDialog.Builder(this)
                 .setTitle("请选择你的武将")
                 .setMultiChoiceItems(wuJiang, null, new DialogInterface.OnMultiChoiceClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int index, boolean flag) {
                         isCheck[index] = flag;
                     }
                 }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         StringBuffer stringBuffer = new StringBuffer();
                         for (int i1 = 0; i1 < isCheck.length; i1++) {
                             if(isCheck[i1]){
                                 stringBuffer.append(wuJiang[i1]).append(" ");
                             }
                         }
                         Toast.makeText(AlertDialogActivity3.this, stringBuffer.toString(), Toast.LENGTH_SHORT).show();
                     }
                 }).setNegativeButton("取消", null)
                 .create().show();
    }
}
