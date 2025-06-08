package com.example.music_app;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.music_app.db.DBHelper;

public class RegisterActivity extends Activity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name,edit_mail,edit_psw;
    RelativeLayout rela_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit_name=findViewById(R.id.edit_name);
        edit_mail=findViewById(R.id.edit_mail);
        edit_psw=findViewById(R.id.edit_psw);
        rela_login=findViewById(R.id.rela_login);
        helper = new DBHelper(this);
        rela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = helper.getWritableDatabase();
                String name=edit_name.getText().toString();
                String mail=edit_mail.getText().toString();
                String psw=edit_psw.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("mail", mail);
                values.put("psw", psw);
                db.insert("message", null, values);
                Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

