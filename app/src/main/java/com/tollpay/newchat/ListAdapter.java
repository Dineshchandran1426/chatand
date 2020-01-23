package com.tollpay.newchat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tollpay.newchat.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ListviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView adv_image;

        public ListviewHolder(View itemview){
            super(itemview);
            adv_image = (ImageView)itemview.findViewById(R.id.adv_image);

            itemview.setOnClickListener(this);
        }

        public void bindView(int position){
            adv_image.setImageResource(data_adv.img[position]);
        }
        public void onClick(View view){

        }

    }
}
