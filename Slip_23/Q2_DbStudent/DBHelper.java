package com.example.slip_q2_23_dbstudent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "StudentDB";
    public static final String TABLE_NAME = "Student";
    public static final String COL_SID = "Sid";
    public static final String COL_SNAME = "Sname";
    public static final String COL_PHNO = "Phno";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_SID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_SNAME + " TEXT, " +
                COL_PHNO + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
