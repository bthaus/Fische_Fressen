package com.example.fische_fressen;

import androidx.appcompat.app.AppCompatActivity;
import com.example.fische_fressen.R;
import com.example.fische_fressen.databinding.ActivityDifficultyBinding;
import com.example.fische_fressen.utils.Difficulty;
import com.example.fische_fressen.utils.Global;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DifficultyActivity extends AppCompatActivity {
    private ActivityDifficultyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDifficultyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.displayUserName.setText(Global.getUserName());

        binding.easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setDifficulty(Difficulty.EASY);
                startGame();
            }
        });
        binding.mediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setDifficulty(Difficulty.MEDIUM);
                startGame();
            }
        });
        binding.hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global.setDifficulty(Difficulty.HARD);
                startGame();
            }
        });
    }
    public void startGame(){
        startActivity(new Intent(this, GameScreen.class));
    }
}