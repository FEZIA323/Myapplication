package com.example.music_app.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.music_app.LoginActivity;
import com.example.music_app.R;
import com.example.music_app.activity.AiAnswerActivity;
import com.example.music_app.util.Const;

public class MyFragment extends Fragment {
    TextView text_name,text_one,text_two,text_three;
    TextView text_huancun;
    RelativeLayout rela_huancun,rela_log,rela_ai;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle save){
        View v = inflater.inflate(R.layout.activity_my,null);
        text_name=v.findViewById(R.id.text_name);
        text_name.setText(Const.name);
        text_one=v.findViewById(R.id.text_one);
        text_two=v.findViewById(R.id.text_two);
        text_three=v.findViewById(R.id.text_three);
        text_huancun=v.findViewById(R.id.text_huancun);
        rela_huancun=v.findViewById(R.id.rela_huancun);
        rela_log=v.findViewById(R.id.rela_log);
        rela_ai=v.findViewById(R.id.rela_ai);

        rela_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), AiAnswerActivity.class);
                startActivity(intent);
            }
        });
        rela_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(getActivity(), LoginActivity.class);
               startActivity(intent);
            }
        });
        return v;
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static MyFragment newInstance( String param1, String param2) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

}
