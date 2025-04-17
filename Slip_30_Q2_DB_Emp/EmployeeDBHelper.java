package com.example.slip30_2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "EmployeeDB";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "Employee";
    private static final String COL_ENO = "Eno";
    private static final String COL_ENAME = "Ename";
    private static final String COL_DESIGNATION = "Designation";
    private static final String COL_SALARY = "Salary";

    public EmployeeDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ENO + " INTEGER PRIMARY KEY, " +
                COL_ENAME + " TEXT, " +
                COL_DESIGNATION + " TEXT, " +
                COL_SALARY + " REAL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertEmployee(int eno, String ename, String designation, double salary) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ENO, eno);
        values.put(COL_ENAME, ename);
        values.put(COL_DESIGNATION, designation);
        values.put(COL_SALARY, salary);

        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;  // returns true if insertion successful
    }

    public String getAllEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        StringBuilder result = new StringBuilder();

        if (cursor.getCount() == 0) {
            return "No Employees Found!";
        }

        while (cursor.moveToNext()) {
            int eno = cursor.getInt(0);
            String ename = cursor.getString(1);
            String designation = cursor.getString(2);
            double salary = cursor.getDouble(3);

            result.append("Eno: ").append(eno).append("\n")
                    .append("Name: ").append(ename).append("\n")
                    .append("Designation: ").append(designation).append("\n")
                    .append("Salary: ").append(salary).append("\n\n");
        }

        cursor.close();
        return result.toString();
    }
}
