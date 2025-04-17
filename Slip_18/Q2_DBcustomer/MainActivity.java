package com.example.slip18_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText idField, nameField, addressField, phoneField;
    Button insertBtn, showBtn;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idField = findViewById(R.id.etID);
        nameField = findViewById(R.id.etName);
        addressField = findViewById(R.id.etAddress);
        phoneField = findViewById(R.id.etPhone);
        insertBtn = findViewById(R.id.btnInsert);
        showBtn = findViewById(R.id.btnShow);

        dbHelper = new DBHelper(this);

        insertBtn.setOnClickListener(view -> {
            int id = Integer.parseInt(idField.getText().toString());
            String name = nameField.getText().toString();
            String address = addressField.getText().toString();
            String phone = phoneField.getText().toString();

            boolean inserted = dbHelper.insertCustomer(id, name, address, phone);

            if (inserted) {
                Toast.makeText(MainActivity.this, "Customer Added!", Toast.LENGTH_SHORT).show();
                idField.setText(""); nameField.setText(""); addressField.setText(""); phoneField.setText("");
            } else {
                Toast.makeText(MainActivity.this, "Insertion Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        showBtn.setOnClickListener(view -> {
            String result = dbHelper.getAllCustomers();
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
        });
    }
}
