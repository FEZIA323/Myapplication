package com.example.music_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.db.DBHelper;
import com.example.music_app.util.Const;

public class LoginActivity extends Activity {
    EditText edit_mail,edit_psw;
    RelativeLayout rela_login;
    DBHelper helper;
    SQLiteDatabase db;
    CheckBox checkbox;
    TextView text_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_mail=findViewById(R.id.edit_mail);
        edit_psw=findViewById(R.id.edit_psw);
        rela_login=findViewById(R.id.rela_login);
        checkbox=findViewById(R.id.checkbox);
        text_register=findViewById(R.id.text_register);
        SharedPreferences sp = getSharedPreferences("Remember", MODE_PRIVATE);
        String name = sp.getString("name", "");
        String password = sp.getString("password", "");
        edit_mail.setText(name);
        edit_psw.setText(password);
        helper = new DBHelper(this);
        rela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edit_mail.getText().toString();
                String password = edit_psw.getText().toString();
                if (name.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "账号和密码不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    if (mail.equals(name) && psw.equals(password)) {
                        Toast.makeText(LoginActivity.this, "登录成功！正在跳转...", Toast.LENGTH_SHORT).show();
                        SharedPreferences sp = getSharedPreferences("Remember", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        if (checkbox.isChecked()) {
                            editor.putString("name", name);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initValue();
    }

    String mail="",psw="";
    public void initValue(){
        db = helper.getWritableDatabase();
        Cursor cursor = db.query("message", null, null, null,
                null, null, null);
        if (cursor == null) {
            edit_mail.setText("");
            edit_psw.setText("");
        } else {
            while (cursor.moveToNext()) {
                String name = cursor.getString(0);
                String mails = cursor.getString(1);
                String psws = cursor.getString(2);
                mail=mails;
                psw=psws;
                Const.name=name;
            }
        }
        db.close();
    }
}

