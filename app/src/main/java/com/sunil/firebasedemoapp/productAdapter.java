package com.sunil.firebasedemoapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productAdapter.productViewHolder> {

    Context ctx;
    List<Product> productList;

    public productAdapter(Context ctx, List<Product> productList) {
        this.ctx = ctx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public productViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(ctx).inflate(R.layout.product_layout,parent,false);
        productViewHolder ProductViewHolder=new productViewHolder(view);
        return ProductViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull productViewHolder holder, int position) {

        Product product=productList.get(position);
        holder.textViewTitle.setText(product.getName());
        holder.viewID.setText(String.valueOf(product.getRollNo()));
        holder.textviewAge.setText(String.valueOf(product.getAge()));
        holder.viewDate.setText(product.getDate());
        holder.imageView.setImageDrawable(ctx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class productViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewTitle,viewID,textviewAge,viewDate;
        public productViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textviewAge=itemView.findViewById(R.id.textviewAge);
            textViewTitle=itemView.findViewById(R.id.textviewTitle);
            viewID=itemView.findViewById(R.id.viewID);
            viewDate=itemView.findViewById(R.id.viewDate);

        }
    }



}
