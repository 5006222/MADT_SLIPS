package com.example.slip6_2;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etAmount;
    Button btnDeposit, btnWithdraw, btnCheck;
    int balance = 0;  // Simple int variable to hold balance

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.etAmount);
        btnDeposit = findViewById(R.id.btnDeposit);
        btnWithdraw = findViewById(R.id.btnWithdraw);
        btnCheck = findViewById(R.id.btnCheck);

        btnDeposit.setOnClickListener(v -> {
            String amt = etAmount.getText().toString();
            if (!amt.isEmpty()) {
                balance += Integer.parseInt(amt);
                Toast.makeText(this, "Deposited ₹" + amt, Toast.LENGTH_SHORT).show();
                etAmount.setText("");
            } else {
                Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show();
            }
        });

        btnWithdraw.setOnClickListener(v -> {
            String amt = etAmount.getText().toString();
            if (!amt.isEmpty()) {
                int withdrawAmt = Integer.parseInt(amt);
                if (withdrawAmt <= balance) {
                    balance -= withdrawAmt;
                    Toast.makeText(this, "Withdrawn ₹" + amt, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Insufficient Balance", Toast.LENGTH_SHORT).show();
                }
                etAmount.setText("");
            } else {
                Toast.makeText(this, "Enter amount", Toast.LENGTH_SHORT).show();
            }
        });

        btnCheck.setOnClickListener(v ->
                Toast.makeText(this, "Current Balance: ₹" + balance, Toast.LENGTH_SHORT).show()
        );
    }
}
