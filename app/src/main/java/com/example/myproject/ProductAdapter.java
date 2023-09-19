package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    ArrayList<Product> list;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_product, viewGroup, false);
        TextView txt_title = view.findViewById(R.id.txt_title);
        TextView txt_content = view.findViewById(R.id.txt_content);
        TextView txt_date = view.findViewById(R.id.txt_date);
        ImageView img = view.findViewById(R.id.img_Product);

        txt_title.setText(list.get(i).getTitle());
        txt_content.setText(list.get(i).getContent());
        txt_date.setText(list.get(i).getDate());
        img.setImageResource(list.get(i).getImage());
        return view;

    }
}
