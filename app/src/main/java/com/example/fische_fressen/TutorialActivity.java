package com.example.fische_fressen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fische_fressen.databinding.ActivityTutorialBinding;

public class TutorialActivity extends AppCompatActivity {
    private ActivityTutorialBinding binding;
    private int activeImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTutorialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        activeImg = R.drawable.tutorial_1;
        binding.tutImgOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int next = 0;
                if(activeImg == R.drawable.tutorial_1){
                    next = R.drawable.tutorial_2;
                }
                else if(activeImg == R.drawable.tutorial_2){
                    next= R.drawable.tutorial_3;
                }
                else if(activeImg == R.drawable.tutorial_3){
                    next=R.drawable.tutorial_4;
                }
                else if(activeImg == R.drawable.tutorial_4){
                    next=R.drawable.tutorial_1;
                }
                activeImg = next;
                binding.tutImgOne.setImageResource(next);
            }
        });
    }
}