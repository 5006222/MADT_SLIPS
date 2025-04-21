package com.example.slip_12_q2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CompanyDB";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Emp(emp_no INTEGER PRIMARY KEY, emp_name TEXT, address TEXT, phone TEXT, salary REAL)");
        db.execSQL("CREATE TABLE Dept(dept_no INTEGER PRIMARY KEY, dept_name TEXT, location TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS Emp");
        db.execSQL("DROP TABLE IF EXISTS Dept");
        onCreate(db);
    }

    // Insert Emp data
    public boolean insertEmp(int emp_no, String emp_name, String address, String phone, double salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("emp_no", emp_no);
        values.put("emp_name", emp_name);
        values.put("address", address);
        values.put("phone", phone);
        values.put("salary", salary);
        long result = db.insert("Emp", null, values);
        return result != -1;
    }

    // Insert Dept data
    public boolean insertDept(int dept_no, String dept_name, String location) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("dept_no", dept_no);
        values.put("dept_name", dept_name);
        values.put("location", location);
        long result = db.insert("Dept", null, values);
        return result != -1;
    }

    // Get all Emp data
    public Cursor getAllEmp() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Emp", null);
    }

    // Get all Dept data
    public Cursor getAllDept() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Dept", null);
    }
}
