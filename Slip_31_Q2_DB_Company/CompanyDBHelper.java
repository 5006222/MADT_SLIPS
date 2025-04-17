package com.example.slip31_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CompanyDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CompanyDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Company";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_ADDRESS = "address";
    private static final String COL_PHNO = "phno";

    public CompanyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_NAME + " TEXT, " +
                COL_ADDRESS + " TEXT, " +
                COL_PHNO + " TEXT)";
        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertCompany(int id, String name, String address, String phno) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID, id);
        values.put(COL_NAME, name);
        values.put(COL_ADDRESS, address);
        values.put(COL_PHNO, phno);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    public String getAllCompanies() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        StringBuilder builder = new StringBuilder();

        if (cursor.getCount() == 0) {
            return "No Company Records Found!";
        }

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String address = cursor.getString(2);
            String phno = cursor.getString(3);

            builder.append("ID: ").append(id).append("\n")
                    .append("Name: ").append(name).append("\n")
                    .append("Address: ").append(address).append("\n")
                    .append("Phone: ").append(phno).append("\n\n");
        }
        cursor.close();
        return builder.toString();
    }
}
