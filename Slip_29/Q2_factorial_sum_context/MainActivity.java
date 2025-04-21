package com.example.slip_q2_29_factorial_sum_context;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);

        // Register EditText for ContextMenu
        registerForContextMenu(numberInput);
    }

    // Create the ContextMenu with options: Factorial and Sum of Digits
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("Select an Action");
        menu.add(0, 1, 0, "Calculate Factorial");
        menu.add(0, 2, 1, "Calculate Sum of Digits");
    }

    // Handle context menu item selections
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String numberString = numberInput.getText().toString();

        if (numberString.isEmpty()) {
            Toast.makeText(this, "Please enter a number first", Toast.LENGTH_SHORT).show();
            return true;
        }

        int number = Integer.parseInt(numberString);

        switch (item.getItemId()) {
            case 1: // Calculate Factorial
                long factorial = calculateFactorial(number);
                Toast.makeText(this, "Factorial: " + factorial, Toast.LENGTH_LONG).show();
                return true;

            case 2: // Calculate Sum of Digits
                int sumOfDigits = calculateSumOfDigits(number);
                Toast.makeText(this, "Sum of Digits: " + sumOfDigits, Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }

    // Method to calculate the factorial of a number
    private long calculateFactorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    // Method to calculate the sum of digits of a number
    private int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
