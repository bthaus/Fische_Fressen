package com.example.fische_fressen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseGVAdapter extends ArrayAdapter<CourseModel> {
    public CourseGVAdapter(@NonNull Context context, LinkedList<CourseModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        CourseModel courseModel = getItem(position);
        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        courseIV.setImageResource(courseModel.getImgid());
        listitemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("test","i have been clicked!"+position);

            remove(courseModel);
            }
        });
        return listitemView;
    }
}