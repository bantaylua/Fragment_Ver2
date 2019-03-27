package com.example.fragment_ver2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resourceLayout;
    private String[] items;
//    private String[] hoten;
//    private String[] lop;
//    private Integer[] grade;
    private Integer[] lvimages;

    public CustomAdapter(Context context, int resourceLayout, String[] items, Integer[] lvimages){
        super(context, resourceLayout, items);
        this.context = context;
        this.resourceLayout = resourceLayout;
        this.items = items;
        this.lvimages = lvimages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(resourceLayout, null);

        ImageView lvImage = (ImageView) row.findViewById(R.id.listview_image);
        TextView  tvName = (TextView) row.findViewById(R.id.listview_title);

        lvImage.setImageResource(lvimages[position]);
        tvName.setText(items[position]);
        return row;
    }
}
