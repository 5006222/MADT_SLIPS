package com.example.slip_12_q2;

import android.os.Bundle;
import android.database.Cursor;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Emp fields
    EditText empNo, empName, address, phone, salary;
    // Dept fields
    EditText deptNo, deptName, location;

    Button btnInsertEmp, btnInsertDept, btnDisplay;
    TextView empData, deptData;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        // Initialize UI elements
        empNo = findViewById(R.id.empNo);
        empName = findViewById(R.id.empName);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        salary = findViewById(R.id.salary);

        deptNo = findViewById(R.id.deptNo);
        deptName = findViewById(R.id.deptName);
        location = findViewById(R.id.location);

        btnInsertEmp = findViewById(R.id.btnInsertEmp);
        btnInsertDept = findViewById(R.id.btnInsertDept);
        btnDisplay = findViewById(R.id.btnDisplay);

        empData = findViewById(R.id.empData);
        deptData = findViewById(R.id.deptData);

        // Insert Emp data
        btnInsertEmp.setOnClickListener(v -> {
            boolean inserted = dbHelper.insertEmp(
                    Integer.parseInt(empNo.getText().toString()),
                    empName.getText().toString(),
                    address.getText().toString(),
                    phone.getText().toString(),
                    Double.parseDouble(salary.getText().toString())
            );
            if (inserted) {
                Toast.makeText(this, "Emp Inserted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to Insert", Toast.LENGTH_SHORT).show();
            }
        });

        // Insert Dept data
        btnInsertDept.setOnClickListener(v -> {
            boolean inserted = dbHelper.insertDept(
                    Integer.parseInt(deptNo.getText().toString()),
                    deptName.getText().toString(),
                    location.getText().toString()
            );
            if (inserted) {
                Toast.makeText(this, "Dept Inserted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Failed to Insert", Toast.LENGTH_SHORT).show();
            }
        });

        // Display both Emp and Dept data
        btnDisplay.setOnClickListener(v -> {
            // Display Emp data
            Cursor cursorEmp = dbHelper.getAllEmp();
            StringBuilder empStringBuilder = new StringBuilder();
            while (cursorEmp.moveToNext()) {
                empStringBuilder.append("EmpNo: ").append(cursorEmp.getInt(0)).append("\n")
                        .append("Name: ").append(cursorEmp.getString(1)).append("\n")
                        .append("Address: ").append(cursorEmp.getString(2)).append("\n")
                        .append("Phone: ").append(cursorEmp.getString(3)).append("\n")
                        .append("Salary: ").append(cursorEmp.getDouble(4)).append("\n\n");
            }

            // Display Dept data
            Cursor cursorDept = dbHelper.getAllDept();
            StringBuilder deptStringBuilder = new StringBuilder();
            while (cursorDept.moveToNext()) {
                deptStringBuilder.append("DeptNo: ").append(cursorDept.getInt(0)).append("\n")
                        .append("Dept Name: ").append(cursorDept.getString(1)).append("\n")
                        .append("Location: ").append(cursorDept.getString(2)).append("\n\n");
            }

            // Set text to display
            empData.setText(empStringBuilder.toString());
            deptData.setText(deptStringBuilder.toString());
        });
    }
}
