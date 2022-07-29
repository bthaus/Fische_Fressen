package com.example.fische_fressen.persistency;

public class StatisticsContract {
    private static StatisticsContract instance;
    private Entry entry = Entry.getInstance();
    private StatisticsContract(){
    }

    public static StatisticsContract getInstance(){
        if(instance == null){
            instance = new StatisticsContract();
        }
        return instance;
    }

    public Entry getEntry() {
        return entry;
    }
}
