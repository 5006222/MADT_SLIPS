package com.example.slip27_q1;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNumber1, editNumber2;
    Button btnSubmit;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber1 = findViewById(R.id.editNumber1);
        editNumber2 = findViewById(R.id.editNumber2);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtResult = findViewById(R.id.txtResult);

        btnSubmit.setOnClickListener(v -> {
            String num1Str = editNumber1.getText().toString();
            String num2Str = editNumber2.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            int num1 = Integer.parseInt(num1Str);
            int num2 = Integer.parseInt(num2Str);

            if (num1 > 10 && num2 > 10) {
                Toast.makeText(this, "Both numbers are greater than 10. Enter again.", Toast.LENGTH_LONG).show();
                editNumber1.setText("");
                editNumber2.setText("");
                txtResult.setText("");
            } else {
                txtResult.setText("Number 1: " + num1 + "\nNumber 2: " + num2);
            }
        });
    }
}
