package com.example.myapplication.base;

import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<T> {

    protected AdapterView.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    protected void onItemHolderClick(RecyclerView.ViewHolder itemHolder) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        } else {
            throw new IllegalStateException("Please call setOnItemClickListener method set the click event listeners!");
        }
    }
}
