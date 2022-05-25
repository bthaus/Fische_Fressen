package com.example.fische_fressen.GameModels;

import java.util.LinkedList;

public class GameObject {

    GameMap gameMap;
    LinkedList<Score>scores=new LinkedList<>();
    LinkedList<Player>players=new LinkedList<>();
    GameMode mode;
    int turntime;



}
