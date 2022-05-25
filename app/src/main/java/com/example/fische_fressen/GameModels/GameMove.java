package com.example.fische_fressen.GameModels;

import java.io.Serializable;

public class GameMove implements Serializable {
  Movement movement;
  Fish fish;
  Position original;
  Position destination;


}
