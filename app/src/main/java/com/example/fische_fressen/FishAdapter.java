package com.example.fische_fressen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.LinkedList;

public class FishAdapter extends ArrayAdapter<FishContainer> {
    public FishAdapter(@NonNull Context context, LinkedList<FishContainer> fishContainerArrayList) {
        super(context, 0, fishContainerArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        FishContainer fishContainer = getItem(position);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        courseIV.setImageResource(fishContainer.getImgid());
        listitemView.setOnClickListener(view -> {
            Log.e("test","i have been clicked!"+position);

        fishContainer.setImgid(R.drawable.ic_launcher_foreground);
        notifyDataSetChanged();
        });
        return listitemView;
    }


}