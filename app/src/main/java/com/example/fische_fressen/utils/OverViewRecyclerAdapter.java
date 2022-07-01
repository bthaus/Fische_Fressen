package com.example.fische_fressen.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fische_fressen.R;

import java.util.List;

public class OverViewRecyclerAdapter extends RecyclerView.Adapter<OverViewRecyclerAdapter.ViewHolder> {
    private List<ShortStatistic> mData;
    private LayoutInflater mInflater;
    private OverViewRecyclerAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public OverViewRecyclerAdapter(Context context, List<ShortStatistic> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public OverViewRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new OverViewRecyclerAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(OverViewRecyclerAdapter.ViewHolder holder, int position) {
        ShortStatistic score = mData.get(position);
        holder.myTextView.setText("Game #"+score.getId());
        holder.amount.setText("Score: "+score.getScore());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;
        TextView amount;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvAnimalName);
            amount = itemView.findViewById(R.id.amount);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public ShortStatistic getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(OverViewRecyclerAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}