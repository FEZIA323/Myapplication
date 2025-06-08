package com.example.music_app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.music_app.R;
import com.example.music_app.util.Const;

public class TwoActivity extends Activity {
    RelativeLayout rela_login;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        rela_login=findViewById(R.id.rela_login);
        rela_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TwoActivity.this,PlayVideoActivity.class);
                intent.putExtra("name","Guided Breathing Exercise.mp3");
                intent.putExtra("position",String.valueOf(5));
                startActivity(intent);
            }
        });
        mHandler.postDelayed(timeRunnable, 1000);//开启心跳检测
    }
    private Runnable timeRunnable = new Runnable() {
        @Override
        public void run() {
            Const.threetime=Const.threetime+1;
            mHandler.removeCallbacksAndMessages(null);
            mHandler.removeCallbacks(timeRunnable);
            mHandler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler!=null){
            mHandler.removeCallbacksAndMessages(null);
            mHandler.removeCallbacks(timeRunnable);
        }
    }
}
