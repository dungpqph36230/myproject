package com.example.myproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.Product;
import com.example.myproject.R;

import java.util.ArrayList;

public class Product_content_adapter extends RecyclerView.Adapter<Product_content_adapter.ProductViewHolder> {
    Context context;
    ArrayList<Product> list;

    public Product_content_adapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product_content, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.txt_title.setText(list.get(position).getTitle());
        holder.txt_date.setText(list.get(position).getDate());
        holder.txt_content.setText(list.get(position).getContent());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txt_title;
        TextView txt_content;
        TextView txt_date;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title = itemView.findViewById(R.id.title_content);
            txt_content = itemView.findViewById(R.id.moto_content);
            txt_date = itemView.findViewById(R.id.date_content);
            imageView =itemView.findViewById(R.id.img_content);
        }
    }
}
