package com.example.fische_fressen.persistency;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class StatisticHelper extends SQLiteOpenHelper {
    private Context context;
    private StatisticsContract contract = StatisticsContract.getInstance();

    public StatisticHelper(Context context) {
        super(context, "statistics.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(contract.getEntry().SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(contract.getInstance().getEntry().SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void addStatistic(int highscore, int movesMade, int highestPointsInOneTurn,
                             int totalPoints, int numberOfYellowFishEaten, int numberOfBlueFishEaten,
                             int numberOfPurpleFishEaten, int numberOfYellowFishExploded, int numberOfBlueFishExploded,
                             int numberOfRedFishExploded, int numberOfPurpleFishExploded, int numberOfMinesExploded) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("Highscore", highscore);
        values.put("movesMade", movesMade);
        values.put("highestPointsInOneTurn", highestPointsInOneTurn);
        values.put("totalpoints", totalPoints);
        values.put("numberOfYellowFishEaten", numberOfYellowFishEaten);
        values.put("numberOfBlueFishEaten", numberOfBlueFishEaten);
        values.put("numberOfPurpleFishEaten", numberOfPurpleFishEaten);
        values.put("numberOfYellowFishExploded", numberOfYellowFishExploded);
        values.put("numberOfBlueFishExploded", numberOfBlueFishExploded);
        values.put("numberOfRedFishExploded", numberOfRedFishExploded);
        values.put("numberOfPurpleFishExploded", numberOfPurpleFishExploded);
        values.put("numberOfMinesExploded", numberOfMinesExploded);

        long result = db.insert("Statistics", null, values);
        if (result == -1) {
          //  Toast.makeText(context, "Adding entry to Database failed", Toast.LENGTH_LONG);
        } else {
          //  Toast.makeText(context, "Entry added to Database", Toast.LENGTH_LONG);
        }
    }

    public Cursor readScores() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Highscore, _id FROM Statistics;";

        return db.rawQuery(query, null);
    }

    public Cursor readSingleStatistic(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Statistics WHERE _id="+id+" ;";

        return db.rawQuery(query, null);
    }
}
