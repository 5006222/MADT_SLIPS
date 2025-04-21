package com.example.slip_20_q2db_game;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_GAME = "Game";
    public static final String COL_GNO = "gno";
    public static final String COL_GNAME = "gname";
    public static final String COL_TYPE = "type";
    public static final String COL_NO_OF_PLAYERS = "no_of_players";

    private static final String CREATE_TABLE_GAME = "CREATE TABLE " + TABLE_GAME + " (" +
            COL_GNO + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_GNAME + " TEXT, " +
            COL_TYPE + " TEXT, " +
            COL_NO_OF_PLAYERS + " INTEGER);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAME);
        onCreate(db);
    }

    // Insert a new game into the database
    public void insertGame(String gname, String type, int no_of_players) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_GNAME, gname);
        values.put(COL_TYPE, type);
        values.put(COL_NO_OF_PLAYERS, no_of_players);
        db.insert(TABLE_GAME, null, values);
        db.close();
    }

    // Update no_of_players to 4 for Badminton games
    public void updatePlayersForBadminton() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NO_OF_PLAYERS, 4);
        db.update(TABLE_GAME, values, COL_TYPE + "=?", new String[]{"Badminton"});
        db.close();
    }

    // Get all records from the Game table
    public Cursor getAllGames() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_GAME, null);
    }
}
