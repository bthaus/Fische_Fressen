package com.example.fische_fressen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;

import com.example.fische_fressen.Exceptions.FishCantEatOtherFishException;
import com.example.fische_fressen.GameModels.Fish;
import com.example.fische_fressen.GameModels.Movement;
import com.example.fische_fressen.utils.GlobalVariables;

import java.util.LinkedList;

public class FishAdapter extends ArrayAdapter<FishContainer> {


    private static final String DEBUG_TAG ="test" ;
    Context gamescreen;
    public FishAdapter(@NonNull Context context, LinkedList<FishContainer> fishContainerArrayList, FishContainer defaultContainer) {
        super(context, 0, fishContainerArrayList);
        gamescreen=context;
        this.defaultContainer=defaultContainer;
    }
    FishContainer defaultContainer;
    int gone=R.drawable.ic_launcher_foreground;

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
        fishContainer.position=position;

        ImageView courseIV = listitemView.findViewById(R.id.idIVcourse);
        courseIV.setImageResource(fishContainer.getImgid());

       listitemView.setOnClickListener(view -> {
           if(fishContainer.fish.getSize()==3){
               fishContainer.fish=GlobalVariables.defaultFish;
               notifyDataSetChanged();
           }else{
               if (GlobalVariables.lastClickedPosition == -1) {
                   GlobalVariables.lastClickedPosition = position;
               } else {

                   Log.e("TAG", GlobalVariables.lastClickedPosition + " position" + position);
                   sendfish(GlobalVariables.lastClickedPosition, getItem(GlobalVariables.lastClickedPosition), getDirection(GlobalVariables.lastClickedPosition, position));
                   GlobalVariables.lastClickedPosition = -1;
               }
           }

       });

        return listitemView;
    }
    public Movement.Direction getDirection(int first, int second){
        Movement.Direction leftOrRight=null;
        Movement.Direction upOrDown=null;
        int row=first%5;
        if(second%5>row){
            leftOrRight= Movement.Direction.RIGHT;
            return Movement.Direction.RIGHT;
        }
        if(second%5<row){
            leftOrRight= Movement.Direction.LEFT;
            return Movement.Direction.LEFT;
        }


        if(first<second){
            upOrDown= Movement.Direction.DOWN;
            return Movement.Direction.DOWN;
        }else{
            upOrDown= Movement.Direction.UP;
            return Movement.Direction.UP;
        }

    }
    public void refill(){
        for (int i = 0; i < 25; i++) {
            if(getItem(i).fish.getSize()==-2) {
                Fish fish=new Fish();
                int rand=(int)(Math.random()*10)%4;
                switch (rand){
                    case 0:   fish.setImageID(R.drawable.bluefish);fish.setSize(1);break;
                    case 1:   fish.setImageID(R.drawable.yellowfish);fish.setSize(0);break;
                    case 2:   fish.setImageID(R.drawable.redfish);fish.setSize(3);break;
                    case 3:   fish.setImageID(R.drawable.purplefish);fish.setSize(2);break;

                }
                getItem(i).fish=fish;
            }
        }

    }

    public void sendfish(int position, FishContainer fish, Movement.Direction direction ){
        Log.e("TAG", "offset "+direction);
        int offset=0;
        int eatable=getItem(position).fish.getSize()-1;
        int fishsize=getItem(position).fish.getSize();
        switch (direction){
            case LEFT:offset=-1;break;
            case RIGHT:offset=1;break;
            case UP:offset=-5;break;
            case DOWN:offset=5;break;
            default:break;
        }
        eat(position,offset,fish);

        notifyDataSetChanged();

    }
    public void eat(int position, int offset,FishContainer fishContainer){
        int safe=getItem(position).getImgid();

        fishContainer.setImgid(gone);
        Log.e("TAG", "offset "+offset);
        try {
            while(true){
                position+=offset;
                fishContainer=getItem(position).eat(fishContainer);

            }
        } catch (IndexOutOfBoundsException e) {
            Log.e("TAG", "wall reached: "+position);
        }catch (FishCantEatOtherFishException e){
            Log.e("TAG", "eat: cant be eaten"+position );
        }
        super.getItem(position-offset).setImgid(safe);
        int size=fishContainer.fish.getSize();
        switch (size){
            case 0:fishContainer.setImgid(R.drawable.yellowfish);break;
            case 1:fishContainer.setImgid(R.drawable.bluefish);break;
            case 2:fishContainer.setImgid(R.drawable.purplefish);break;
            case 3:fishContainer.setImgid(R.drawable.redfish);break;
        }
    }


}