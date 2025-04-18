package com.example.slip29_q1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etNumber;
    Button btnGenerate;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        btnGenerate = findViewById(R.id.btnGenerate);
        tableLayout = findViewById(R.id.tableLayout);

        btnGenerate.setOnClickListener(v -> {
            String input = etNumber.getText().toString().trim();

            if (TextUtils.isEmpty(input)) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
            }

            int number = Integer.parseInt(input);
            tableLayout.removeAllViews(); // Clear previous table

            for (int i = 1; i <= 10; i++) {
                TableRow row = new TableRow(this);

                TextView tv = new TextView(this);
                tv.setText(number + " × " + i + " = " + (number * i));
                tv.setTextSize(18);
                tv.setPadding(10, 10, 10, 10);
                tv.setGravity(Gravity.CENTER);

                row.addView(tv);
                tableLayout.addView(row);
            }
        });
    }
}
