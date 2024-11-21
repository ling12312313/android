package com.example.sqlitestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlitestorage.entity.Student;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLStorageActivity extends AppCompatActivity {

    private static final String TAG = "XMLStorageActivity";
    Button btnSave;
    Button btnLoad;
    EditText etName;
    EditText etPhone;
    TextView tvCnt;

    private void inital(){
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        tvCnt = findViewById(R.id.txtShowCnt);
        tvCnt.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmlstorage);
        inital();//初始化控件


    }

    private void savetoXml(Student student) throws Exception{
        //xml文件生成器
        XmlSerializer serializer= Xml.newSerializer();
        File file=
                new File(Environment.getExternalStorageDirectory(),
                        "stu_info.xml");
        FileOutputStream fi_out=new FileOutputStream(file);
        serializer.setOutput(fi_out,"UTF-8");
        serializer.startDocument("UTF-8",true);
        serializer.startTag(null,"students");
        serializer.startTag(null,"student");
        //将Person对象的用户名属性写入
        serializer.startTag(null,"name");
        serializer.text(student.getUsername());
        serializer.endTag(null,"name");

        //将Person对象的密码写入
        serializer.startTag(null,"phone");
        serializer.text(student.getPhone());
        serializer.endTag(null,"phone");
        //结束标签
        serializer.endTag(null,"student");
        serializer.endTag(null,"students");
        serializer.endDocument();
        serializer.flush();
        fi_out.close();

    }

    private List<Student> loadFromXml(File file) {

        List<Student> students = null;
        Student student = null;
        XmlPullParser pullParser = Xml.newPullParser();
        try {
            FileInputStream fis = new FileInputStream(file);
            //为PULL解析器设置要解析的XML数据
            pullParser.setInput(fis,"UTF-8");
            int event = pullParser.getEventType();
            while(event!=XmlPullParser.END_DOCUMENT){
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        students = new ArrayList<Student>();
                        break;
                    case XmlPullParser.START_TAG:
                        if("name".equals(pullParser.getName())){
                            String name = pullParser.nextText();
                            student = new Student();
                            student.setUsername(name);
                        }

                        if("phone".equals(pullParser.getName())){
                            String phone = pullParser.nextText();
                            student.setPhone(phone);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("student".equals(pullParser.getName())){
                            students.add(student);
                            student = null;    }
                        break;
                }
                event = pullParser.next();
            }

        }catch(Exception ex){
                ex.printStackTrace();
        }
        return students;
    }



    public void operate(View view) {
        switch (view.getId()){
            case R.id.btnSave:
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                Student student = new Student(name,phone);
                try {
                    savetoXml(student);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast.makeText(this,"保存成功！",Toast.LENGTH_LONG).show();
                break;

            case R.id.btnLoad:
               // String xmlFile = Environment.getExternalStorageDirectory()+"/stu_info.xml";
                File file=
                        new File(Environment.getExternalStorageDirectory(),
                                "stu_info.xml");

              //  Log.d(TAG, "operate: "+xmlFile);
               // InputStream xml = this.getClass().getClassLoader().getResourceAsStream(xmlFile);
                List<Student> students = loadFromXml(file);
                for(Student stu : students){
                   tvCnt.setText(tvCnt.getText().toString()+stu.toString());
                }
                Toast.makeText(this,"加载成功！",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
