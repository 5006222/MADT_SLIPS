package com.example.slip19_2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNumber;
    TextView txtResult;
    final int MENU_FACTORIAL = 1;
    final int MENU_SUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber = findViewById(R.id.edtNumber);
        txtResult = findViewById(R.id.txtResult);

        // Register context menu for EditText
        registerForContextMenu(edtNumber);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Choose Operation");
        menu.add(0, MENU_FACTORIAL, 0, "Calculate Factorial");
        menu.add(0, MENU_SUM, 0, "Calculate Sum of Digits");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String input = edtNumber.getText().toString().trim();

        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return true;
        }

        int num = Integer.parseInt(input);
        switch (item.getItemId()) {
            case MENU_FACTORIAL:
                txtResult.setText("Factorial: " + calculateFactorial(num));
                return true;

            case MENU_SUM:
                txtResult.setText("Sum of Digits: " + sumOfDigits(num));
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    private long calculateFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
