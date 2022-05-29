package com.example.fische_fressen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fische_fressen.Exceptions.BottomReachedException;
import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.Movement;
import com.example.fische_fressen.utils.Dinner;
import com.example.fische_fressen.utils.GlobalVariables;

import java.util.LinkedList;

public class FishAdapter extends ArrayAdapter<FishContainer> {
    private static final String DEBUG_TAG = "Test - FishAdapter";

    private FishContainer defaultContainer;
    private GameScreen gameScreen;
    private Context context;
    private int gone = R.drawable.ic_launcher_foreground;

    public FishAdapter(@NonNull Context context, LinkedList<FishContainer> fishContainerArrayList, FishContainer defaultContainer) {
        super(context, 0, fishContainerArrayList);
        this.context = context;
        this.defaultContainer = defaultContainer;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void unselect() {
        //TODO: implement
    }

    @SuppressLint("ClickableViewAccessibility")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }
        FishContainer fishContainer = getItem(position);
        fishContainer.position = position;

        ImageView fishview = listitemView.findViewById(R.id.idIVcourse);

        fishview.setImageResource(fishContainer.getImgid());

        listitemView.setOnClickListener(view -> {

            if (GlobalVariables.lastClickedPosition == -1) {
                GlobalVariables.lastClickedPosition = position;


            } else {
                if (GlobalVariables.lastClickedPosition == position && fishContainer.fish.getSize() == 3) {
                    fishContainer.fish = GlobalVariables.defaultFish;
                    gameScreen.setPoints(10);
                }
                Log.e("TAG", GlobalVariables.lastClickedPosition + " position" + position);
                sendfish(GlobalVariables.lastClickedPosition, getItem(GlobalVariables.lastClickedPosition), getDirection(GlobalVariables.lastClickedPosition, position));
                GlobalVariables.lastClickedPosition = -1;

                if (checkVictory()) {
                    gameScreen.win();
                }

                // fallAll();
            }
        });
        return listitemView;
    }

    private boolean checkVictory() {
        boolean checker = true;
        for (int i = 0; i < 25; i++) {
            if (getItem(i).fish.getSize() != -2) {
                checker = false;
            }
        }
        return checker;
    }

    private void fallAll() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 19; i >= 0; i--) {
            while (true) {
                try {
                    getItem(i).fall(getItem(i + 5));
                } catch (BottomReachedException e) {
                    break;
                }
            }

        }
        notifyDataSetChanged();
    }

    public Movement.Direction getDirection(int first, int second) {

        int row = first % 5;
        if (second % 5 > row) {
            return Movement.Direction.RIGHT;
        }

        if (second % 5 < row) {
            return Movement.Direction.LEFT;
        }

        if (first < second) {
            return Movement.Direction.DOWN;
        } else {
            return Movement.Direction.UP;
        }

    }

    public void refill() {
        for (int i = 0; i < 25; i++) {
            if (getItem(i).fish.getSize() == -2) {
                Fish fish = new Fish();
                int rand = (int) (Math.random() * 10) % 3;
                switch (rand) {
                    case 0:
                        fish.setImageID(R.drawable.bluefish);
                        fish.setSize(1);
                        break;
                    case 1:
                        fish.setImageID(R.drawable.yellowfish);
                        fish.setSize(0);
                        break;
                    case 2:
                        fish.setImageID(R.drawable.purplefish);
                        fish.setSize(2);
                        break;
                }
                getItem(i).fish = fish;
            }
        }

    }

    public void sendfish(int position, FishContainer fish, Movement.Direction direction) {
        Log.e("TAG", "offset " + direction);
        int offset = 0;

        //Offset Werte nun in Movement (enum)
        eat(position, direction.getDirectionOffset(), fish);

        notifyDataSetChanged();

    }

    public void eat(int position, int offset, FishContainer fishContainer) {
        int safe = getItem(position).getImgid();
        fishContainer.setImgid(gone);

        Log.e("TAG", "offset " + offset);

        int points = 2;
        try {
            while (true) {
                position += offset;
                Dinner dinner = getItem(position).eat(fishContainer);
                fishContainer = dinner.container;
                points *= dinner.points;
            }
        } catch (IndexOutOfBoundsException e) {
            Log.e("TAG", "wall reached: " + position);
        } catch (FishCantEatOtherFishException e) {
            Log.e("TAG", "eat: cant be eaten" + position);
        }
        super.getItem(position - offset).setImgid(safe);
        int size = fishContainer.fish.getSize();
        switch (size) {
            case 0:
                fishContainer.setImgid(R.drawable.yellowfish);
                break;
            case 1:
                fishContainer.setImgid(R.drawable.bluefish);
                break;
            case 2:
                fishContainer.setImgid(R.drawable.purplefish);
                break;
            case 3:
                fishContainer.setImgid(R.drawable.redfish);
                break;
        }
        if (points > 2) {
            gameScreen.setPoints(points);
        }

    }
}