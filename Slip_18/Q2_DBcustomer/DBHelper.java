package com.example.slip18_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CustomerDB.db";
    public static final String TABLE_NAME = "Customer";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Customer(id INTEGER PRIMARY KEY, name TEXT, address TEXT, phno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customer");
        onCreate(db);
    }

    public boolean insertCustomer(int id, String name, String address, String phno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("name", name);
        cv.put("address", address);
        cv.put("phno", phno);
        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    public String getAllCustomers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Customer", null);
        StringBuilder data = new StringBuilder();

        if (cursor.getCount() == 0) {
            return "No records found.";
        }

        while (cursor.moveToNext()) {
            data.append("ID: ").append(cursor.getInt(0)).append("\n")
                    .append("Name: ").append(cursor.getString(1)).append("\n")
                    .append("Address: ").append(cursor.getString(2)).append("\n")
                    .append("Phone: ").append(cursor.getString(3)).append("\n\n");
        }
        cursor.close();
        return data.toString();
    }
}
