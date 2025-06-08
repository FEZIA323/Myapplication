package com.example.music_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.music_app.R;
import com.example.music_app.util.Slump;

import java.util.ArrayList;
import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private List<Slump> data = new ArrayList<>();
    private Context context;

    public FruitAdapter(List<Slump> data, Context context) {
        this.data = data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view,parent,false);
        }
        TextView txt_id = convertView.findViewById(R.id.txt_id);
        TextView text_name = convertView.findViewById(R.id.text_name);
        TextView text_phone = convertView.findViewById(R.id.text_phone);
        txt_id.setText(data.get(position).getTitle()+"");
        text_name.setText(data.get(position).getTime());
        //text_name.setText(data.get(position).getPhone());
        return convertView;
    }
}
