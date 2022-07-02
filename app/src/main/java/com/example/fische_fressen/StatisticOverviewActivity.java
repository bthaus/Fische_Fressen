package com.example.fische_fressen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fische_fressen.databinding.ActivityStatisticOverviewBinding;
import com.example.fische_fressen.persistency.StatisticHelper;
import com.example.fische_fressen.utils.OverViewRecyclerAdapter;
import com.example.fische_fressen.utils.ShortStatistic;

import java.util.LinkedList;
import java.util.List;

public class StatisticOverviewActivity extends AppCompatActivity implements OverViewRecyclerAdapter.ItemClickListener{
    OverViewRecyclerAdapter adapter;
    private AppBarConfiguration appBarConfiguration;
    private ActivityStatisticOverviewBinding binding;

    private StatisticHelper sh;

/*

        binding = ActivityStatisticScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        // set up the RecyclerView
        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, GameStatistics.getBundles());

        recyclerView.setAdapter(adapter);
    }
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatisticOverviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<ShortStatistic> values = new LinkedList<>();
        //Getting data from db
        sh = new StatisticHelper(this);
        Cursor c = sh.readScores();
        if(c.getCount() == 0){
            Toast.makeText(this,"There is no data yet", Toast.LENGTH_LONG);
        }
        else{
            while(c.moveToNext()){
                values.add(new ShortStatistic(c.getInt(0), c.getInt(1)));
            }
        }



        RecyclerView rv = binding.recyclerview;
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OverViewRecyclerAdapter(this,values, this);
        adapter.setClickListener(this);
        binding.recyclerview.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, StatisticScreen.class);
        intent.putExtra("id",adapter.getItem(position).getId());
        startActivity(intent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}