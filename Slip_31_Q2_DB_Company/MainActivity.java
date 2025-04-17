package com.example.slip31_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtName, edtAddress, edtPhone;
    Button btnInsert, btnDisplay;
    TextView txtResult;
    CompanyDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);
        btnInsert = findViewById(R.id.btnInsert);
        btnDisplay = findViewById(R.id.btnDisplay);
        txtResult = findViewById(R.id.txtResult);

        dbHelper = new CompanyDBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String address = edtAddress.getText().toString();
                String phno = edtPhone.getText().toString();

                boolean isInserted = dbHelper.insertCompany(id, name, address, phno);

                if (isInserted) {
                    Toast.makeText(MainActivity.this, "Company Inserted!", Toast.LENGTH_SHORT).show();
                    edtId.setText("");
                    edtName.setText("");
                    edtAddress.setText("");
                    edtPhone.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insertion Failed. Check ID uniqueness!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dbHelper.getAllCompanies();
                txtResult.setText(data);
            }
        });
    }
}
