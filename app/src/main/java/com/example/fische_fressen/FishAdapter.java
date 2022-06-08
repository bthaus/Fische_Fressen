package com.example.fische_fressen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
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
import com.example.fische_fressen.Exceptions.WallReachedException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.GameStatistics;
import com.example.fische_fressen.GameModels.Movement;
import com.example.fische_fressen.utils.Dinner;
import com.example.fische_fressen.utils.Global;

import java.util.LinkedList;

public class FishAdapter extends ArrayAdapter<FishContainer> {
    private static final String DEBUG_TAG = "Test - FishAdapter";

    private FishContainer defaultContainer;
    private GameScreen gameScreen;
    private Context context;

    public boolean logicDone=false;


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



    public boolean selected(int position) {
        FishContainer fishContainer=getItem(position);
        if (Global.lastClickedPosition == -1) {
            Global.lastClickedPosition = position;

            switch (fishContainer.fish.getSize()) {
                case 0:
                    fishContainer.setImgid(R.drawable.yellowfishselected);
                    break;
                case 1:
                    fishContainer.setImgid(R.drawable.bluefishselected);
                    break;
                case 2:
                    fishContainer.setImgid(R.drawable.purplefishselected);
                    break;
                case 3:
                    fishContainer.setImgid(R.drawable.redfishselected);
                    break;
                case 5: fishContainer.setImgid(R.drawable.mineselected);
            }
            notifyDataSetChanged();
            return false;

        } else {
            switch (getItem(Global.lastClickedPosition).fish.getSize()) {
                case 0:
                    getItem(Global.lastClickedPosition).setImgid(R.drawable.yellowfish);
                    break;
                case 1:
                    getItem(Global.lastClickedPosition).setImgid(R.drawable.bluefish);
                    break;
                case 2:
                    getItem(Global.lastClickedPosition).setImgid(R.drawable.purplefish);
                    break;
                case 3:
                    getItem(Global.lastClickedPosition).setImgid(R.drawable.redfish);
                    break;
                case 5: getItem(Global.lastClickedPosition).setImgid(R.drawable.mine);
                break;
            }
          notifyDataSetChanged();
            return true;
        }
    }
    public void redrawAssets(){
        for (int i = 0; i < 25; i++) {
            getItem(i).fish.setImageID(getItem(i).getImgid());
        }
        gameScreen.datasetchanged();

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
//the reason the dateset wasnt updated during eating fish is: onclicklistener works on UIthread, hence it is only not blocked once the sendfish is done. because notifydatasetchanged only sets a flag to change but doesnt force it
        //it only gets done once the onclicklisteneer is finished
        listitemView.setOnClickListener(view -> {

          if(selected(position)){

             LogicRunner logicRunner=new LogicRunner(position);
             logicRunner.start();

          }
            Log.e("TAG", "onclicklistener done: ");
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

        //calls the fallloop multiple times in case a fish gets stuck
        for (int j=0;j<5;j++) {
            for (int i = 0; i < 5; i++) {
                if(getItem(i).fish.getSize()==-2){
                    getItem(i).fish=Global.getRandomFish();
                    gameScreen.datasetchanged();
                }
            }
            for (int i = 19; i >= 0; i--) {
                while (true) {
                    try {
                        getItem(i).fall(getItem(i + 5));
                        gameScreen.datasetchanged();
                    } catch (BottomReachedException e) {
                        break;
                    }
                }
                if(i%5==1&&j==0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }



    }

    //extracted from the click listener because it would block the uithread
    class LogicRunner extends Thread{
        int position;
        public LogicRunner(int position) {
            logicDone=false;
            this. position=position;
        }

        @Override
        public void run() {

            sendfish(position);

            if (checkVictory()) {
                gameScreen.win();
            }
            fallAll();
            Global.lastClickedPosition = -1;
            logicDone=true;

        }
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

    public void sendfish(int newPosition) {
        GameStatistics.makeTurn();
        int position=Global.lastClickedPosition;
        FishContainer fish=getItem(position); //the fishcontainer you clicked
        Movement.Direction direction=getDirection(position,newPosition); //get the firection
        if (position == newPosition && fish.fish.getSize() == 3) {
            int temp=gameScreen.scorepoints;
          explode(newPosition);
          int temp2=gameScreen.scorepoints;
          temp=temp2-temp;
            Log.e("TAG", "explodepoints: "+temp );
          gameScreen.setPoints(-temp);
          gameScreen.setPoints(temp);


            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameScreen.datasetchanged();
            return;
        }
        if(position==newPosition && fish.fish.getSize()==5){
            int temp=gameScreen.scorepoints;
            explode(newPosition);
            int temp2=gameScreen.scorepoints;
            temp=temp2-temp;
            Log.e("TAG", "explodepoints: "+temp );
            gameScreen.setPoints(-temp);
            gameScreen.setPoints(temp);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameScreen.datasetchanged();
            return;
        }
        Log.e("TAG", "offset " + direction);
        int offset = 0;

        //Offset Werte nun in Movement (enum)
        eat(position, direction.getDirectionOffset(), fish);



    }

    private void explode(int newPosition) {


            if(newPosition%5==0){
                if ( getItem(newPosition+1).explode()) {
                   explode(newPosition+1);
                }
                try {
                    if ( getItem(newPosition-5).explode()) {
                        explode(newPosition-5);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } try {

                    if ( getItem(newPosition+5).explode()) {
                        explode(newPosition+5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getItem(newPosition).explode();

                return;
            }
            if((newPosition+1)%5==0){
                if ( getItem(newPosition-1).explode()) {
                    explode(newPosition-1);
                }
                try {
                    if ( getItem(newPosition-5).explode()) {
                        explode(newPosition-5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } try {

                    if ( getItem(newPosition+5).explode()) {
                        explode(newPosition+5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                getItem(newPosition).explode();

                return;
            }
        if ( getItem(newPosition+1).explode()) {
            explode(newPosition+1);
        }
        if ( getItem(newPosition-1).explode()) {
            explode(newPosition-1);
        }
        try {
            if ( getItem(newPosition-5).explode()) {
                explode(newPosition-5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } try {

            if ( getItem(newPosition+5).explode()) {
                explode(newPosition+5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getItem(newPosition).explode();
        Log.e("TAG", "explode: ");

    }

    public int eat(int position, int offset, FishContainer fishContainer) {

        Log.e("TAG", "offset " + offset);
        Looper.prepare();
        int points = 2;
        int timeout=300;
        try {
            while (true) {

                //calculate offset
                position += offset;
                //get item of newly calculated position and execute eat
                Dinner dinner = getItem(position).eat(fishContainer);
                fishContainer = dinner.container;
                points *= dinner.points;
              gameScreen.datasetchanged();
              if(fishContainer.fish.getSize()>0){
                  gameScreen.bubble(fishContainer.fish.getSize());

              }
              if (dinner.points!=1  ) {
                    gameScreen.setPoints(points);
                }
                try {
                    Thread.sleep(timeout);
                    timeout=(int)(timeout*0.66);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            if(dinner.wallreached){
                break;
            }
            }
        } catch (IndexOutOfBoundsException e) {
            Log.e("TAG", "wall reached: " + position);
        } catch (FishCantEatOtherFishException e) {
            Log.e("TAG", "eat: cant be eaten" + position);
        } catch (WallReachedException e) {
            e.printStackTrace();
        }


        return fishContainer.position;
    }
}