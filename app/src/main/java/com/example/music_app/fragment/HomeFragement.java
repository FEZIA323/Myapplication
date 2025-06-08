package com.example.music_app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.music_app.R;
import com.example.music_app.activity.OneActivity;
import com.example.music_app.activity.TwoActivity;
import com.example.music_app.activity.WebViewActivity;

public class HomeFragement extends Fragment {
    LinearLayout line_one,line_two;
    TextView inputSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle save){
        View v = inflater.inflate(R.layout.activity_home,null);
        line_one=v.findViewById(R.id.line_one);
        line_two=v.findViewById(R.id.line_two);
        inputSearch=v.findViewById(R.id.inputSearch);
        line_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), OneActivity.class);
                startActivity(intent);
            }
        });
        line_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), TwoActivity.class);
                startActivity(intent);
            }
        });
        inputSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), WebViewActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static HomeFragement newInstance( String param1, String param2) {
        HomeFragement fragment = new HomeFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

}
