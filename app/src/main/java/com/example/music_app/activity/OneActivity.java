package com.example.music_app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.music_app.R;
import com.example.music_app.adapter.FruitAdapter;
import com.example.music_app.util.Const;
import com.example.music_app.util.Slump;

import java.util.ArrayList;
import java.util.List;

public class OneActivity extends Activity {

    RelativeLayout rela_login;
    ListView list_view;
    FruitAdapter fruitadapter;
    List<Slump> datalist = new ArrayList<>();
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        list_view=findViewById(R.id.list_view);
        Slump been=new Slump();
        been.setTitle("5-Minute Meditation.mp3");
        datalist.add(been);
        Slump been2=new Slump();
        been2.setTitle("10-Minute Meditation.mp3");
        datalist.add(been2);
        Slump been3=new Slump();
        been3.setTitle("Rainday Antiques.mp3");
        datalist.add(been3);
        Slump been4=new Slump();
        been4.setTitle("Spiritual Healing.mp3");
        datalist.add(been4);
        fruitadapter=new FruitAdapter(datalist,OneActivity.this);
        list_view.setAdapter(fruitadapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(OneActivity.this,PlayVideoActivity.class);
                intent.putExtra("name",datalist.get(i).getTitle());
                intent.putExtra("position",String.valueOf(i));
                startActivity(intent);
            }
        });
        mHandler.postDelayed(timeRunnable, 1000);//开启心跳检测
    }
    private Runnable timeRunnable = new Runnable() {
        @Override
        public void run() {
            Const.onetime=Const.onetime+1;
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

