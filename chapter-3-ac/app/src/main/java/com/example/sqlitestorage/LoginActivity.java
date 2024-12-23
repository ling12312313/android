package com.example.sqlitestorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private EditText account;
    private EditText password;
    private CheckBox checkBox;
    private Button login;


    private void initview() {
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accountText = account.getText().toString();
                String passwordText = password.getText().toString();
                if(accountText.equals("admin") && passwordText.equals("123456")) {
                    if(checkBox.isChecked()) {
                        preferences.edit().putString("account",accountText).
                                putString("password",passwordText).
                                putBoolean("remember",true).commit();
                    } else {
                        preferences.edit().clear().commit();
                    }
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "用户名或密码错误",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        initview();
        boolean checked = preferences.getBoolean("remember",false);
        if(checked) {
            account.setText(preferences.getString("account",""));
            password.setText(preferences.getString("password",""));
            checkBox.setChecked(true);
        }
    }
}
